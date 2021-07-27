package lesson3.homework.packBoxesWithArray;

import java.util.Arrays;

public class Box<T extends Fruit> {
    private T[] fruits;

    @SafeVarargs
    public Box(T... fruits) {
        this.fruits = fruits;
    }

    public T[] getFruits() {
        return fruits;
    }

    public void setFruits(T[] fruits) {
        this.fruits = fruits;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + Arrays.toString(fruits) +
                '}';
    }

    public float calcWeight() {
        float weight = 0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> boxToCompare, float tolerance) {
        float result = (Math.abs(this.calcWeight() - (boxToCompare).calcWeight()));
//        System.out.println(result + " vs " + tolerance);
        return result < tolerance;
    }

    public void transferringFruitToAnotherBox(Box<T> boxToTransfer) {

        for (int i = 0; i < fruits.length; i++) {
            boxToTransfer.getFruits()[i] = fruits[i];
            fruits[i] = null;
        }
    }
}



