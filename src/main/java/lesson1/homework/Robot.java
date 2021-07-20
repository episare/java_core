package lesson1.homework;

public class Robot implements CanRun, CanJump {
    private String name;
    private int maxJumpingHeight;
    private int maxRunningLength;
    private int runningSpeed;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, int maxJumpingHeight, int maxRunningLength, int runningSpeed) {
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

    public boolean run(RunningTrack runningTrack) {
        System.out.println("Я робот " + this.name + ", я бегу!");
        return (runningTrack.getLength() <= this.maxRunningLength);
    }

    public boolean jump(Wall wall) {
        System.out.println("Я робот " + this.name + ", я прыгаю!");
        return wall.getHeight() <= this.maxJumpingHeight;
    }

    @Override
    public double getRunningTime(RunningTrack runningTrack) {
        return (double) runningTrack.getLength() / this.runningSpeed;
    }
}
