package Lesson7.homework;

//import Lesson7.homework.mock.MockAccuweatherModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final WeatherModel weatherModel = new AccuweatherModel();
    Map<Integer, Period> inputOptions = new HashMap<>();
    private String stringResponseFromWeatherModel;
    private final ConverterJsonForecastToPrint converterJsonForecastToPrint = new ConverterJsonForecastToPrint();

    public Controller() {
        inputOptions.put(1, Period.NOW);
        inputOptions.put(5, Period.FIVE_DAYS);
    }

    public String getWeather(String userInputString, String selectedCity) throws IOException, CityNotFoundException {
        Integer userInputInteger = Integer.parseInt(userInputString);

        switch (inputOptions.get(userInputInteger)) {
            case NOW:
                stringResponseFromWeatherModel = weatherModel.getWeather(selectedCity, Period.NOW);
//                stringResponseFromWeatherModel = new MockAccuweatherModel().getWeather(1);
                break;
            case FIVE_DAYS:
                stringResponseFromWeatherModel = weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
//                stringResponseFromWeatherModel = new MockAccuweatherModel().getWeather(5);
                break;
        }
        return converterJsonForecastToPrint.convertJsonForecastToPrint(stringResponseFromWeatherModel);
    }
}
