package lesson1.homework;

public class Cat implements CanRun, CanJump {
    private String name;
    private String color;
    private int age;
    private int maxJumpingHeight;
    private int maxRunningLength;
    private int runningSpeed;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name, String color, int age, int maxJumpingHeight, int maxRunningLength, int runningSpeed) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxJumpingHeight = maxJumpingHeight;
        this.maxRunningLength = maxRunningLength;
        this.runningSpeed = runningSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaxJumpingHeight() {
        return maxJumpingHeight;
    }

    public void setMaxJumpingHeight(int maxJumpingHeight) {
        this.maxJumpingHeight = maxJumpingHeight;
    }

    public int getMaxRunningLength() {
        return maxRunningLength;
    }

    public void setMaxRunningLength(int maxRunningLength) {
        this.maxRunningLength = maxRunningLength;
    }

    public boolean run(RunningTrack runningTrack) {
        System.out.println("Я " + this.color + " кот " + this.name + ", я бегу!");
        return (runningTrack.getLength() <= this.maxRunningLength);
    }

    public boolean jump(Wall wall) {
        System.out.println("Я " + this.color + " кот " + this.name + ", я прыгаю!");
        return wall.getHeight() <= this.maxJumpingHeight;
    }

    @Override
    public double getRunningTime(RunningTrack runningTrack) {
        return (double) runningTrack.getLength() / this.runningSpeed;
    }
}
