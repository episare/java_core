package Lesson7.homework.forecastwithdetails;

public class DailyForecasts {
    private String Date;
    private Temperature Temperature;
    private Day Day;
    private Night Night;

    public DailyForecasts() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.Temperature = temperature;
    }

    public Day getDay() {
        return Day;
    }

    public void setDay(Day day) {
        this.Day = day;
    }

    public Night getNight() {
        return Night;
    }

    public void setNight(Night night) {
        this.Night = night;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "date='" + Date + '\'' +
                ", temperature=" + Temperature +
                ", day=" + Day +
                ", night=" + Night +
                '}';
    }
}
