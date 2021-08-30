package Lesson8.homework;

import Lesson8.homework.entity.WeatherData;
import Lesson8.homework.myexceptions.CityNotFoundException;
import Lesson8.homework.myexceptions.NoResponseBodyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "yV3Av48iTf6PXjQTGobjqe97MrHYxDPf";
    //private static final String API_KEY = "Rx193q9XeqqyQcSs0OSsBMqWqqdtToWx";
    private static final String API_KEY_QUARY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String SEARCH_QUERY = "q";
    private static final String LOCATION_KEY_FIELD_NAME = "Key";
    private static final String LANGUAGE_FIELD_NAME = "language";
    private static final String LANGUAGE_RU = "ru";
    private static final String LANGUAGE_EN = "en_us";
    private static final String DETAILS_FIELD_NAME = "details";
    private static final String DETAILS_TRUE = "true";
    private static final String DETAILS_FALSE = "false";
    private static final String METRIC_FIELD_NAME = "metric";
    private static final String METRIC_TRUE = "true";
    private static final String METRIC_FALSE = "false";
    private static final String LOCALIZED_NAME_FIELD_NAME = "LocalizedName";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public ArrayList<WeatherData> getWeather(String selectedCity, Period period)
            throws IOException, NoResponseBodyException {
        ArrayList<WeatherData> arrayListWeatherData;
        String responseWithForecast = "";
        String[] keyWithCity;
        keyWithCity = detectCityKey(selectedCity);
        String cityKey = keyWithCity[0];
        String city = keyWithCity[1];
        ResponseBody responseBody;

        switch (period) {
            case NOW:
                // http://dataservice.accuweather.com/forecasts/v1/daily/1day/
                HttpUrl httpUrlOneDay = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(cityKey)
                        .addQueryParameter(API_KEY_QUARY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_FIELD_NAME, LANGUAGE_RU)
                        .addQueryParameter(DETAILS_FIELD_NAME, DETAILS_TRUE)
                        .addQueryParameter(METRIC_FIELD_NAME, METRIC_TRUE)
                        .build();

                Request requestOneDay = new Request.Builder()
                        .url(httpUrlOneDay)
                        .get()
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(requestOneDay).execute();
                responseBody = oneDayForecastResponse.body();
                if (responseBody == null) {
                    throw new NoResponseBodyException("Ошибка в http запросе");
                }
                responseWithForecast = responseBody.string();

                break;

            case FIVE_DAYS:
                // http://dataservice.accuweather.com/forecasts/v1/daily/5day/
                HttpUrl httpUrlFiveDays = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(keyWithCity[0])
                        .addQueryParameter(API_KEY_QUARY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_FIELD_NAME, LANGUAGE_RU)
                        .addQueryParameter(DETAILS_FIELD_NAME, DETAILS_TRUE)
                        .addQueryParameter(METRIC_FIELD_NAME, METRIC_TRUE)
                        .build();

                Request requestFiveDays = new Request.Builder()
                        .url(httpUrlFiveDays)
                        .get()
                        .build();

                Response fiveDaysForecastResponse = okHttpClient.newCall(requestFiveDays).execute();
                responseBody = fiveDaysForecastResponse.body();
                if (responseBody == null) {
                    throw new NoResponseBodyException("Ошибка в http запросе");
                }
                responseWithForecast = responseBody.string();

                break;
        }
        arrayListWeatherData = new ConverterJsonForecast().convertJsonForecastToWeatherData(city, responseWithForecast);
        try {
            dataBaseRepository.saveWeatherToDataBase(city, arrayListWeatherData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayListWeatherData;
    }

    private String[] detectCityKey(String inputStringWithSelectedCity)
            throws IOException, CityNotFoundException, NoResponseBodyException {
        // http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        String[] keyWithCity = new String[2];
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUARY_PARAM, API_KEY)
                .addQueryParameter(SEARCH_QUERY, inputStringWithSelectedCity)
                .addQueryParameter(LANGUAGE_FIELD_NAME, LANGUAGE_RU)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();
        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            throw new NoResponseBodyException("Ошибка в http запросе");
        }
        String responseStringWithCityKey = responseBody.string();
        if (!responseStringWithCityKey.contains(LOCATION_KEY_FIELD_NAME)) {
            throw new CityNotFoundException("Город c введенным именем " + inputStringWithSelectedCity + " не найден!");
        }
        keyWithCity[0] = objectMapper.readTree(responseStringWithCityKey).get(0)
                .at("/" + LOCATION_KEY_FIELD_NAME).asText();
        keyWithCity[1] = objectMapper.readTree(responseStringWithCityKey).get(0)
                .at("/" + LOCALIZED_NAME_FIELD_NAME).asText();

        System.out.println("Выбранный город: " + keyWithCity[1]);

        return keyWithCity;
    }

}
