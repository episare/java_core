package Lesson7.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;

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

    public String getWeather(String selectedCity, Period period) throws IOException {
        String responseWithForecast = "";

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
                        .addPathSegment(detectCityKey(selectedCity))
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
                responseWithForecast = oneDayForecastResponse.body().string();

//                File file = new File("responseOneDayForecastWithDetails");
//                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
//                    objectOutputStream.writeObject(responseWithForecast);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

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
                        .addPathSegment(detectCityKey(selectedCity))
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
                responseWithForecast = fiveDaysForecastResponse.body().string();

//                File file = new File("responseFiveDaysForecastWithDetails");
//                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
//                    objectOutputStream.writeObject(responseWithForecast);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                break;
        }
        return responseWithForecast;
    }

    private String detectCityKey(String selectedCity) throws IOException, CityNotFoundException {
        // http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUARY_PARAM, API_KEY)
                .addQueryParameter(SEARCH_QUERY, selectedCity)
                .addQueryParameter(LANGUAGE_FIELD_NAME, LANGUAGE_RU)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseStringWithCityKey = response.body().string();
        if (!responseStringWithCityKey.contains(LOCATION_KEY_FIELD_NAME)) {
            throw new CityNotFoundException("Город c введенным именем " + selectedCity + " не найден!");
        }

        System.out.println("Выбранный город: " + objectMapper.readTree(responseStringWithCityKey).get(0)
                .at("/" + LOCALIZED_NAME_FIELD_NAME).asText());
        return objectMapper.readTree(responseStringWithCityKey).get(0)
                .at("/" + LOCATION_KEY_FIELD_NAME).asText();
    }
}
