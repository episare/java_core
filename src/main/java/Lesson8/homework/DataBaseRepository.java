package Lesson8.homework;

import Lesson8.homework.entity.WeatherData;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseRepository {
    String insertWeather = "insert into weather (" +
            "city, " +
            "local_date, " +
            "max_temperature, " +
            "min_temperature, " +
            "day_icon_phrase, " +
            "day_long_phrase, " +
            "day_total_liquid, " +
            "day_wind_direction, " +
            "day_wind_speed, " +
            "day_wind_gust, " +
            "night_icon_phrase, " +
            "night_long_phrase, " +
            "night_total_liquid, " +
            "night_wind_direction, " +
            "night_wind_speed, " +
            "night_wind_gust, " +
            "temperature_unit, " +
            "liquid_unit, " +
            "wind_speed_unit) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public boolean saveWeatherToDataBase(String city, ArrayList<WeatherData> weatherList) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            connection.setAutoCommit(false);
            for (WeatherData weather : weatherList) {
                PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
                saveWeather.setString(1, city);
                saveWeather.setString(2, weather.getDate());
                saveWeather.setDouble(3, weather.getMaxTemperature());
                saveWeather.setDouble(4, weather.getMinTemperature());
                saveWeather.setString(5, weather.getDayIconPhrase());
                saveWeather.setString(6, weather.getDayLongPhrase());
                saveWeather.setDouble(7, weather.getDayTotalLiquid());
                saveWeather.setString(8, weather.getDayWindDirection());
                saveWeather.setDouble(9, weather.getDayWindSpeed());
                saveWeather.setDouble(10, weather.getDayWindGust());
                saveWeather.setString(11, weather.getNightIconPhrase());
                saveWeather.setString(12, weather.getNightLongPhrase());
                saveWeather.setDouble(13, weather.getNightTotalLiquid());
                saveWeather.setString(14, weather.getNightWindDirection());
                saveWeather.setDouble(15, weather.getNightWindSpeed());
                saveWeather.setDouble(16, weather.getNightWindGust());
                saveWeather.setString(17, weather.getTemperatureUnit());
                saveWeather.setString(18, weather.getLiquidUnit());
                saveWeather.setString(19, weather.getWindSpeedUnit());
                saveWeather.execute();
            }
            connection.commit();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено");

    }

    public ArrayList<WeatherData> getSavedToDBWeather () {
        ArrayList<WeatherData> weatherDataList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            while (resultSet.next()) {
                WeatherData weatherData = new WeatherData();
                weatherData.setCity(resultSet.getString("city"));
                weatherData.setDate(resultSet.getString("local_date"));
                weatherData.setMaxTemperature(resultSet.getDouble("max_temperature"));
                weatherData.setMinTemperature(resultSet.getDouble("min_temperature"));
                weatherData.setDayIconPhrase(resultSet.getString("day_icon_phrase"));
                weatherData.setDayLongPhrase(resultSet.getString("day_long_phrase"));
                weatherData.setDayTotalLiquid(resultSet.getDouble("day_total_liquid"));
                weatherData.setDayWindDirection(resultSet.getString("day_wind_direction"));
                weatherData.setDayWindSpeed(resultSet.getDouble("day_wind_speed"));
                weatherData.setDayWindGust(resultSet.getDouble("day_wind_gust"));
                weatherData.setNightIconPhrase(resultSet.getString("night_icon_phrase"));
                weatherData.setNightLongPhrase(resultSet.getString("night_long_phrase"));
                weatherData.setNightTotalLiquid(resultSet.getDouble("night_total_liquid"));
                weatherData.setNightWindDirection(resultSet.getString("night_wind_direction"));
                weatherData.setNightWindSpeed(resultSet.getDouble("night_wind_speed"));
                weatherData.setNightWindGust(resultSet.getDouble("night_wind_gust"));
                weatherData.setTemperatureUnit(resultSet.getString("temperature_unit"));
                weatherData.setLiquidUnit(resultSet.getString("liquid_unit"));
                weatherData.setWindSpeedUnit(resultSet.getString("wind_speed_unit"));
                weatherDataList.add(weatherData);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherDataList;
    }
}
