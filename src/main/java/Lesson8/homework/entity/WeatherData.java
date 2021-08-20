package Lesson8.homework.entity;

public class WeatherData {
    private String city;
    private String date;
    private Double maxTemperature;
    private Double minTemperature;
    private String dayIconPhrase;
    private String dayLongPhrase;
    private Double dayTotalLiquid;
    private String dayWindDirection;
    private Double dayWindSpeed;
    private Double dayWindGust;
    private String nightIconPhrase;
    private String nightLongPhrase;
    private Double nightTotalLiquid;
    private String nightWindDirection;
    private Double nightWindSpeed;
    private Double nightWindGust;
    private String temperatureUnit;
    private String liquidUnit;
    private String windSpeedUnit;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getDayIconPhrase() {
        return dayIconPhrase;
    }

    public void setDayIconPhrase(String dayIconPhrase) {
        this.dayIconPhrase = dayIconPhrase;
    }

    public String getDayLongPhrase() {
        return dayLongPhrase;
    }

    public void setDayLongPhrase(String dayLongPhrase) {
        this.dayLongPhrase = dayLongPhrase;
    }

    public Double getDayTotalLiquid() {
        return dayTotalLiquid;
    }

    public void setDayTotalLiquid(Double dayTotalLiquid) {
        this.dayTotalLiquid = dayTotalLiquid;
    }

    public String getLiquidUnit() {
        return liquidUnit;
    }

    public void setLiquidUnit(String liquidUnit) {
        this.liquidUnit = liquidUnit;
    }

    public String getDayWindDirection() {
        return dayWindDirection;
    }

    public void setDayWindDirection(String dayWindDirection) {
        this.dayWindDirection = dayWindDirection;
    }

    public Double getDayWindSpeed() {
        return dayWindSpeed;
    }

    public void setDayWindSpeed(Double dayWindSpeed) {
        this.dayWindSpeed = dayWindSpeed;
    }

    public Double getDayWindGust() {
        return dayWindGust;
    }

    public void setDayWindGust(Double dayWindGust) {
        this.dayWindGust = dayWindGust;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public void setWindSpeedUnit(String windSpeedUnit) {
        this.windSpeedUnit = windSpeedUnit;
    }

    public String getNightIconPhrase() {
        return nightIconPhrase;
    }

    public void setNightIconPhrase(String nightIconPhrase) {
        this.nightIconPhrase = nightIconPhrase;
    }

    public String getNightLongPhrase() {
        return nightLongPhrase;
    }

    public void setNightLongPhrase(String nightLongPhrase) {
        this.nightLongPhrase = nightLongPhrase;
    }

    public Double getNightTotalLiquid() {
        return nightTotalLiquid;
    }

    public void setNightTotalLiquid(Double nightTotalLiquid) {
        this.nightTotalLiquid = nightTotalLiquid;
    }

    public String getNightWindDirection() {
        return nightWindDirection;
    }

    public void setNightWindDirection(String nightWindDirection) {
        this.nightWindDirection = nightWindDirection;
    }

    public Double getNightWindSpeed() {
        return nightWindSpeed;
    }

    public void setNightWindSpeed(Double nightWindSpeed) {
        this.nightWindSpeed = nightWindSpeed;
    }

    public Double getNightWindGust() {
        return nightWindGust;
    }

    public void setNightWindGust(Double nightWindGust) {
        this.nightWindGust = nightWindGust;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", maxTemperature=" + maxTemperature +
                ", minTemperature=" + minTemperature +
                ", temperatureUnit='" + temperatureUnit + '\'' +
                ", dayIconPhrase='" + dayIconPhrase + '\'' +
                ", dayLongPhrase='" + dayLongPhrase + '\'' +
                ", dayTotalLiquid=" + dayTotalLiquid +
                ", liquidUnit='" + liquidUnit + '\'' +
                ", dayWindDirection='" + dayWindDirection + '\'' +
                ", dayWindSpeed=" + dayWindSpeed +
                ", dayWindGust=" + dayWindGust +
                ", windSpeedUnit='" + windSpeedUnit + '\'' +
                ", nightIconPhrase='" + nightIconPhrase + '\'' +
                ", nightLongPhrase='" + nightLongPhrase + '\'' +
                ", nightTotalLiquid=" + nightTotalLiquid +
                ", nightWindDirection='" + nightWindDirection + '\'' +
                ", nightWindSpeed=" + nightWindSpeed +
                ", nightWindGust=" + nightWindGust +
                '}';
    }
}

