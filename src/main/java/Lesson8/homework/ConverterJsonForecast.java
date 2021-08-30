package Lesson8.homework;

import Lesson8.homework.entity.WeatherData;
import Lesson8.homework.jsonclasses.DailyForecasts;
import Lesson8.homework.jsonclasses.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class ConverterJsonForecast {
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String BLANK = " ";
    private static final String PUNKT = ".";
    private static final String SEPARATOR = "_______";

    ObjectMapper objectMapper = new ObjectMapper();
//    ArrayList<WeatherData> arrayListWeatherData = new ArrayList<>();

    public ArrayList<WeatherData> convertJsonForecastToWeatherData(String city, String jsonForecast)
            throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        Root forecastFromJson = objectMapper.readValue(jsonForecast, Root.class);
        ArrayList<WeatherData> arrayListWeatherData = new ArrayList<>();

        for (DailyForecasts forecast : forecastFromJson.getDailyForecasts()) {
            WeatherData weatherData = new WeatherData();
            weatherData.setCity(city);
            weatherData.setDate(forecast.getDate());
            weatherData.setMaxTemperature(forecast.getTemperature().getMaximum().getValue());
            weatherData.setMinTemperature(forecast.getTemperature().getMinimum().getValue());
            weatherData.setTemperatureUnit(forecast.getTemperature().getMaximum().getUnit());
            weatherData.setDayIconPhrase(forecast.getDay().getIconPhrase().toLowerCase());
            weatherData.setDayLongPhrase(forecast.getDay().getLongPhrase().toLowerCase());
            weatherData.setDayTotalLiquid(forecast.getDay().getTotalLiquid().getValue());
            weatherData.setLiquidUnit(forecast.getDay().getTotalLiquid().getUnit());
            weatherData.setDayWindDirection(forecast.getDay().getWind().getDirection().getLocalized());
            weatherData.setDayWindSpeed(forecast.getDay().getWind().getSpeed().getValue());
            weatherData.setDayWindGust(forecast.getDay().getWindGust().getSpeed().getValue());
            weatherData.setWindSpeedUnit(forecast.getDay().getWind().getSpeed().getUnit());

            weatherData.setNightIconPhrase(forecast.getNight().getIconPhrase().toLowerCase());
            weatherData.setNightLongPhrase(forecast.getNight().getLongPhrase().toLowerCase());
            weatherData.setNightTotalLiquid(forecast.getNight().getTotalLiquid().getValue());
            weatherData.setNightWindDirection(forecast.getNight().getWind().getDirection().getLocalized());
            weatherData.setNightWindSpeed(forecast.getNight().getWind().getSpeed().getValue());
            weatherData.setNightWindGust(forecast.getNight().getWindGust().getSpeed().getValue());

            arrayListWeatherData.add(weatherData);
        }
        return arrayListWeatherData;
    }

    public String convertWeatherDataToPrint(ArrayList<WeatherData> arrayListWeatherData) {
        StringBuilder stringForecast = new StringBuilder();
        for (WeatherData wD : arrayListWeatherData) {
            String text = wD.getCity() + ": прогноз погоды на " + wD.getDate() + NEW_LINE
                    + "Максимальная температура " + wD.getMaxTemperature() + BLANK + wD.getTemperatureUnit() + COMMA
                    + " минимальная температура " + wD.getMinTemperature() + BLANK + wD.getTemperatureUnit() + COMMA
                    + NEW_LINE
                    + "днем " + wD.getDayIconPhrase() + COMMA + BLANK + wD.getDayLongPhrase() + COMMA
                    + " влажность " + wD.getDayTotalLiquid() + BLANK + wD.getLiquidUnit() + COMMA
                    + " ветер " + wD.getDayWindDirection() + BLANK
                    + wD.getDayWindSpeed() + BLANK + wD.getWindSpeedUnit() + COMMA
                    + " порывы до " + wD.getDayWindGust() + BLANK + wD.getWindSpeedUnit() + SEMICOLON
                    + NEW_LINE
                    + "ночью " + wD.getNightIconPhrase() + COMMA + BLANK + wD.getNightLongPhrase() + COMMA
                    + " влажность " + wD.getNightTotalLiquid() + wD.getLiquidUnit() + COMMA
                    + " ветер " + wD.getNightWindDirection() + BLANK
                    + wD.getNightWindSpeed() + wD.getWindSpeedUnit() + COMMA
                    + " порывы до " + wD.getNightWindGust() + BLANK + wD.getWindSpeedUnit() + PUNKT + NEW_LINE
                    + SEPARATOR + NEW_LINE;
            stringForecast.append(text);
        }
        return stringForecast.toString();
    }

}
