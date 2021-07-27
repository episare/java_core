package lesson3.homework.packBoxesWithArrayList;

public class Main {

    public static void main(String[] args) {
        float tolerance = 0.01f;

        Box<Apple> appleBox = new Box<>();
        appleBox.fillListWithArray(new Apple(0.32f), new Apple(0.18f),
                new Apple(0.21f), new Apple(0.11f));
        appleBox.addFruitToBox(new Apple(0.45f));
        appleBox.addFruitToBox(new Apple(0.12f));
        System.out.println(appleBox.getFruitList());
        System.out.println("Общий вес: " + appleBox.calcWeight());


        Box<Orange> orangeBox = new Box<>();
        orangeBox.fillListWithArray(new Orange(0.31f), new Orange(0.28f), new Orange(0.3f));
        orangeBox.addFruitToBox(new Orange(0.5f));
        System.out.println(orangeBox.getFruitList());
        System.out.println("Общий вес: " + orangeBox.calcWeight());

        if (appleBox.compareWithAnotherBox(orangeBox, tolerance)) {
            System.out.println("Коробки весят одинаково");
        } else {
            System.out.println("Коробки различаются по весу");
        }

        Box<Apple> emptyAppleBox = new Box<>();
        Box<Orange> emptyOrangeBox = new Box<>();

        appleBox.transferringFruitToAnotherBox(emptyAppleBox);
        System.out.println(appleBox.getFruitList());
        System.out.println(emptyAppleBox.getFruitList());

        orangeBox.transferringFruitToAnotherBox(emptyOrangeBox);
        System.out.println(orangeBox.getFruitList());
        System.out.println(emptyOrangeBox.getFruitList());

    }


}
