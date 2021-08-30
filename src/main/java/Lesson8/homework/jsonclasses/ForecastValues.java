package Lesson8.homework.jsonclasses;

public class ForecastValues {
    protected String IconPhrase;
    protected String LongPhrase;
    protected Lesson8.homework.jsonclasses.Wind Wind;
    protected Lesson8.homework.jsonclasses.WindGust WindGust;
    protected Lesson8.homework.jsonclasses.TotalLiquid TotalLiquid;
    protected int CloudCover;

    public ForecastValues() {
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public String getLongPhrase() {
        return LongPhrase;
    }

    public void setLongPhrase(String longPhrase) {
        LongPhrase = longPhrase;
    }

    public Lesson8.homework.jsonclasses.Wind getWind() {
        return Wind;
    }

    public void setWind(Lesson8.homework.jsonclasses.Wind wind) {
        Wind = wind;
    }

    public Lesson8.homework.jsonclasses.WindGust getWindGust() {
        return WindGust;
    }

    public void setWindGust(Lesson8.homework.jsonclasses.WindGust windGust) {
        WindGust = windGust;
    }

    public Lesson8.homework.jsonclasses.TotalLiquid getTotalLiquid() {
        return TotalLiquid;
    }

    public void setTotalLiquid(Lesson8.homework.jsonclasses.TotalLiquid totalLiquid) {
        TotalLiquid = totalLiquid;
    }

    public int getCloudCover() {
        return CloudCover;
    }

    public void setCloudCover(int cloudCover) {
        CloudCover = cloudCover;
    }
}
