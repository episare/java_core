package Lesson7.homework.forecastwithdetails;

public class ForecastValues {
    protected String IconPhrase;
    protected String LongPhrase;
    protected Wind Wind;
    protected WindGust WindGust;
    protected TotalLiquid TotalLiquid;
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

    public Wind getWind() {
        return Wind;
    }

    public void setWind(Wind wind) {
        Wind = wind;
    }

    public WindGust getWindGust() {
        return WindGust;
    }

    public void setWindGust(WindGust windGust) {
        WindGust = windGust;
    }

    public TotalLiquid getTotalLiquid() {
        return TotalLiquid;
    }

    public void setTotalLiquid(TotalLiquid totalLiquid) {
        TotalLiquid = totalLiquid;
    }

    public int getCloudCover() {
        return CloudCover;
    }

    public void setCloudCover(int cloudCover) {
        CloudCover = cloudCover;
    }
}
