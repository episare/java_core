package Lesson8.homework.myexceptions;

public class CityNotFoundException extends NullPointerException{
    public CityNotFoundException(String s) {
        super(s);
    }
}
