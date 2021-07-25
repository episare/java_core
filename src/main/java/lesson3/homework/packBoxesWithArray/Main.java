package lesson3.homework.packBoxesWithArray;

public class Main {
    public static void main(String[] args) {
        float tolerance = 0.01f;
        Box<Apple> appleBox = new Box<>(
                new Apple(0.32f), new Apple(0.18f), new Apple(0.21f), new Apple(0.2f));
        System.out.println(appleBox.calcWeight());
        Box<Orange> orangeBox = new Box<>(
                new Orange(0.31f), new Orange(0.28f), new Orange(0.3f));
        System.out.println(orangeBox.calcWeight());

        Box<Apple> appleBox1 = new Box<>(
                new Apple(0.1f), new Apple(0.1f),
                new Apple(0.1f), new Apple(0.1f),
                new Apple(0.1f), new Apple(0.1f));
        System.out.println(appleBox1.calcWeight());
        Box<Orange> orangeBox1 = new Box<>(
                new Orange(0.2f), new Orange(0.2f), new Orange(0.2f));
        System.out.println(orangeBox1.calcWeight());

        System.out.println(appleBox.compare(orangeBox, tolerance));
        System.out.println(appleBox1.compare(orangeBox1, tolerance));
    }
}
