package Lesson7.homework;

import java.io.IOException;

public interface WeatherModel {
    String getWeather(String selectedCity, Period period) throws IOException;
}
