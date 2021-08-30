package Lesson8.homework;

import Lesson8.homework.entity.WeatherData;

import java.io.IOException;
import java.util.ArrayList;

public interface WeatherModel {
    ArrayList<WeatherData> getWeather(String selectedCity, Period period) throws IOException;
}
