package lesson1.homework;

public class RunningTrack {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean getResultOfRunning(CanRun runner) {
        boolean ok = runner.run(this);
        if (ok) {
            System.out.println("Пробежал(а) за " + runner.getRunningTime(this));
        } else {
            System.out.println("Не смог(ла) пробежать");
        }
        return ok;
    }
}
