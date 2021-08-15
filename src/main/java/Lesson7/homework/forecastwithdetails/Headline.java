package Lesson7.homework.forecastwithdetails;

public class Headline {
    private String Text;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }

    @Override
    public String toString() {
        return "Headline{" +
                "Text='" + Text + '\'' +
                '}';
    }
}
