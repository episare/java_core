package Lesson7.homework;

import Lesson7.homework.forecastwithdetails.DailyForecasts;
import Lesson7.homework.forecastwithdetails.Root;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class ConverterJsonForecastToPrint {
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String BLANK = " ";
    private static final String SEPARATOR = "_______";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String convertJsonForecastToPrint(String jsonForecast) throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        Root forecastFromJson = objectMapper.readValue(jsonForecast, Root.class);
        ArrayList<String> arrayListDailyForecasts = new ArrayList<>();

        for (DailyForecasts forecast : forecastFromJson.getDailyForecasts()) {
            String date = forecast.getDate();
            String dayMaxTemperature = forecast.getTemperature().getMaximum().getValue()
                    + forecast.getTemperature().getMaximum().getUnit();
            String dayMinTemperature = forecast.getTemperature().getMinimum().getValue()
                    + forecast.getTemperature().getMinimum().getUnit();
            String dayIconPhrase = forecast.getDay().getIconPhrase().toLowerCase();
            String dayLongPhrase = forecast.getDay().getLongPhrase().toLowerCase();
            String dayTotalLiquid = forecast.getDay().getTotalLiquid().getValue()
                    + BLANK + forecast.getDay().getTotalLiquid().getUnit();
            String dayWindDirection = forecast.getDay().getWind().getDirection().getLocalized();
            String dayWindSpeed = forecast.getDay().getWind().getSpeed().getValue()
                    + BLANK + forecast.getDay().getWind().getSpeed().getUnit();
            String dayWindGust = forecast.getDay().getWindGust().getSpeed().getValue()
                    + BLANK + forecast.getDay().getWindGust().getSpeed().getUnit();

            String nightIconPhrase = forecast.getNight().getIconPhrase().toLowerCase();
            String nightLongPhrase = forecast.getNight().getLongPhrase().toLowerCase();
            String nightTotalLiquid = forecast.getNight().getTotalLiquid().getValue()
                    + BLANK + forecast.getNight().getTotalLiquid().getUnit();
            String nightWindDirection = forecast.getNight().getWind().getDirection().getLocalized();
            String nightWindSpeed = forecast.getNight().getWind().getSpeed().getValue()
                    + BLANK + forecast.getNight().getWind().getSpeed().getUnit();
            String nightWindGust = forecast.getNight().getWindGust().getSpeed().getValue()
                    + BLANK + forecast.getNight().getWindGust().getSpeed().getUnit();

            String stringForecast = "Прогноз погоды на " + date + NEW_LINE + "Максимальная температура "
                    + dayMaxTemperature + COMMA + " минимальная температура " + dayMinTemperature + COMMA + NEW_LINE
                    + "днем " + dayIconPhrase + COMMA + BLANK + dayLongPhrase + COMMA
                    + " влажность " + dayTotalLiquid + COMMA
                    + " ветер " + dayWindDirection + BLANK + dayWindSpeed + COMMA
                    + " порывы до " + dayWindGust + SEMICOLON + NEW_LINE
                    + "ночью " + nightIconPhrase + COMMA + BLANK + nightLongPhrase + COMMA
                    + " влажность " + nightTotalLiquid + COMMA
                    + " ветер " + dayWindDirection + BLANK + dayWindSpeed + COMMA
                    + " порывы до " + dayWindGust;

            arrayListDailyForecasts.add(stringForecast);
        }

        StringBuilder stringForecastsForUser = new StringBuilder();

        for (String stringForecast : arrayListDailyForecasts) {
            stringForecastsForUser.append(NEW_LINE).append(stringForecast).append(NEW_LINE).append(SEPARATOR);
        }
        return (stringForecastsForUser + NEW_LINE);
    }
}