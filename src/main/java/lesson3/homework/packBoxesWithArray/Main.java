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

//        Урок 3. Обобщения
//
//        Даны классы: Fruit, Apple extends Fruit, Orange extends Fruit.
//
//---     Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//            поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//
//---     Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//            вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//
//---     Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//            которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//            Можно сравнивать коробки с яблоками и апельсинами;
//---
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//            Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//            Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//            которые были в первой;
//---         Не забываем про метод добавления фрукта в коробку.
}
