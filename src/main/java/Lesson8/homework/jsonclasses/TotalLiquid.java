package Lesson8.homework.jsonclasses;

public class TotalLiquid {
    private double Value;
    private String Unit;

    public void setValue(double Value) {
        this.Value = Value;
    }

    public double getValue() {
        return this.Value;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getUnit() {
        return this.Unit;
    }
}