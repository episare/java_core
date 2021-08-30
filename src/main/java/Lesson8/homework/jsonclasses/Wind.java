package Lesson8.homework.jsonclasses;

public class Wind {
    private Lesson8.homework.jsonclasses.Speed Speed;
    private Lesson8.homework.jsonclasses.Direction Direction;

    public void setSpeed(Lesson8.homework.jsonclasses.Speed Speed) {
        this.Speed = Speed;
    }

    public Lesson8.homework.jsonclasses.Speed getSpeed() {
        return this.Speed;
    }

    public void setDirection(Lesson8.homework.jsonclasses.Direction Direction) {
        this.Direction = Direction;
    }

    public Lesson8.homework.jsonclasses.Direction getDirection() {
        return this.Direction;
    }
}

