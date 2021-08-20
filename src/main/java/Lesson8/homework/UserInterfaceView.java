package Lesson8.homework;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private static final String NEW_LINE = "\n";
    private static final String BREAK = "0";

    private final Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Для завершения работы введите " + BREAK + NEW_LINE
                    + "Для продолжения работы введите имя города:");
            String city = scanner.next();

            if (city.equals(BREAK)) break;

            System.out.println("Введите 1 для прогноза погоды на один день;" + NEW_LINE
                    + "5 для прогноза погоды на пять дней;" + NEW_LINE
                    + BREAK + " для завершения работы");

            String pattern = "[" + BREAK + "15]";
            while (!scanner.hasNext(pattern)) {
                System.out.println("Некорректный ввод!");
                System.out.println("Введите 1 для прогноза погоды на один день;" + NEW_LINE
                        + "5 для прогноза погоды на пять дней;" + NEW_LINE
                        + BREAK + " для завершения работы");

                scanner.next();
            }

            String command = scanner.next();
            if (command.equals(BREAK)) break;

            try {
                System.out.println(controller.getWeather(command, city));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CityNotFoundException e) {
                System.out.println(e.getMessage() + " Повторите ввод");
            } catch (NoResponseBodyException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

    }
}
