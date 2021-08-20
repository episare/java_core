package Lesson7.homework.forecastwithdetails;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("Root")
public class Root {
    private Headline Headline;
    private List <DailyForecasts> DailyForecasts;

    public Root() {
    }

    public Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(Headline headline) {
        this.Headline = headline;
    }

    public List<Lesson7.homework.forecastwithdetails.DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<Lesson7.homework.forecastwithdetails.DailyForecasts> dailyForecasts) {
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
