package Lesson8.homework.jsonclasses;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("Root")
public class Root {
    private Lesson8.homework.jsonclasses.Headline Headline;
    private List <Lesson8.homework.jsonclasses.DailyForecasts> DailyForecasts;

    public Root() {
    }

    public Lesson8.homework.jsonclasses.Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(Lesson8.homework.jsonclasses.Headline headline) {
        this.Headline = headline;
    }

    public List<Lesson8.homework.jsonclasses.DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<Lesson8.homework.jsonclasses.DailyForecasts> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }

    @Override
    public String toString() {
        return "AccuweatherForecastOneDay{" +
                "headline=" + Headline +
                ", dailyForecasts=" + DailyForecasts +
                '}';
    }
}
