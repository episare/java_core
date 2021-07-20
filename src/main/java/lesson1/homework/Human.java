package lesson1.homework;

public class Human implements CanRun, CanJump {
    private String name;
    private int maxJumpingHeight;
    private int maxRunningLength;
    private int runningSpeed;

    public Human(String name, int maxJumpingHeight, int maxRunningLength, int runningSpeed) {
        this.name = name;
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

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public boolean run(RunningTrack runningTrack) {
        System.out.println("Я человек " + this.name + ", я бегу!");
        return (runningTrack.getLength() <= this.maxRunningLength);
    }

    public boolean jump(Wall wall) {
        System.out.println("Я человек " + this.name + ", я прыгаю!");
        return wall.getHeight() <= this.maxJumpingHeight;
    }

    @Override
    public double getRunningTime(RunningTrack runningTrack) {
        return (double) runningTrack.getLength() / this.runningSpeed;
    }
}