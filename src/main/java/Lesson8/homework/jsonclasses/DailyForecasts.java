package Lesson8.homework.jsonclasses;

public class DailyForecasts {
    private String Date;
    private Lesson8.homework.jsonclasses.Temperature Temperature;
    private Lesson8.homework.jsonclasses.Day Day;
    private Lesson8.homework.jsonclasses.Night Night;

    public DailyForecasts() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public Lesson8.homework.jsonclasses.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Lesson8.homework.jsonclasses.Temperature temperature) {
        this.Temperature = temperature;
    }

    public Lesson8.homework.jsonclasses.Day getDay() {
        return Day;
    }

    public void setDay(Lesson8.homework.jsonclasses.Day day) {
        this.Day = day;
    }

    public Lesson8.homework.jsonclasses.Night getNight() {
        return Night;
    }

    public void setNight(Lesson8.homework.jsonclasses.Night night) {
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
