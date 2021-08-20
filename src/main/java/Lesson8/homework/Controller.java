package Lesson8.homework;

import Lesson8.homework.entity.WeatherData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final WeatherModel weatherModel = new AccuweatherModel();
    Map<Integer, Period> inputOptions = new HashMap<>();
    DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public Controller() {
        inputOptions.put(1, Period.NOW);
        inputOptions.put(5, Period.FIVE_DAYS);
    }

    public String getWeather(String userInputString, String selectedCity)
            throws IOException, CityNotFoundException, NoResponseBodyException {
        Integer userInputInteger = Integer.parseInt(userInputString);
        ArrayList<WeatherData> arrayListWeatherData = new ArrayList<>();

                switch (inputOptions.get(userInputInteger)) {
            case NOW:
                arrayListWeatherData = weatherModel.getWeather(selectedCity, Period.NOW);
//                arrayListWeatherData = dataBaseRepository.getSavedToDBWeather();

                break;
            case FIVE_DAYS:
                arrayListWeatherData = weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);

                break;
        }
        return new ConverterJsonForecast().convertWeatherDataToPrint(arrayListWeatherData);
    }
}
