package lesson1.homework;

public class Main {
    public static void main(String[] args) {

        Object[] competitions = {
                new Human("Настя", 2, 500, 100),
                new Human("Николай", 2, 1500, 110),
                new Cat("Мурка", "серая", 6, 2, 3500, 55),
                new Cat("Мурзик", "черный", 4, 3, 2500, 70),
                new Robot("Алекс", 4, 2500, 250)
        };

        Object[] obstacles = {
                new RunningTrack(1000), new Wall(3), new Wall(5), new RunningTrack(3000)
        };

        for (Object competition : competitions) {
            for (Object obstacle : obstacles) {
                if (obstacle instanceof Wall) {
                    if (!((Wall) obstacle).getResultJumping((CanJump) competition)) break;
                } else if (obstacle instanceof RunningTrack) {
                    if (!((RunningTrack) obstacle).getResultOfRunning((CanRun) competition)) break;
                }
            }
        }
    }
}
