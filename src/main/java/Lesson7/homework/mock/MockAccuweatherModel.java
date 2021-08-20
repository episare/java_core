package Lesson7.homework.mock;

import java.io.*;

public class MockAccuweatherModel {

    public String getWeather(Integer mode) {
        String fileNameWithForecasts = "";
        switch (mode) {
            case 1:
                fileNameWithForecasts = "responseOneDayForecastWithDetails";
                break;
            case 5:
                fileNameWithForecasts = "responseFiveDaysForecastWithDetails";
                break;
        }

        String restoredResponseForecastBody = "";
        File file = new File(fileNameWithForecasts);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            restoredResponseForecastBody = (String) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return restoredResponseForecastBody;

    }
}
