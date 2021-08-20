package Lesson8.homework.jsonclasses;

public class Temperature {
    private Lesson8.homework.jsonclasses.Minimum Minimum;
    private Lesson8.homework.jsonclasses.Maximum Maximum;

    public void setMinimum(Lesson8.homework.jsonclasses.Minimum Minimum) {
        this.Minimum = Minimum;
    }

    public Lesson8.homework.jsonclasses.Minimum getMinimum() {
        return this.Minimum;
    }

    public void setMaximum(Lesson8.homework.jsonclasses.Maximum Maximum) {
        this.Maximum = Maximum;
    }

    public Lesson8.homework.jsonclasses.Maximum getMaximum() {
        return this.Maximum;
    }
}
