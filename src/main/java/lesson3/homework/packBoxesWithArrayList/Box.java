package lesson3.homework.packBoxesWithArrayList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Box<T extends Fruit> implements Comparable {
    private ArrayList<T> fruitList = new ArrayList<>();

    public Box() {
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public void addFruitToBox(T fruit) {
        fruitList.add(fruit);
    }

    public void fillListWithArray(T... list) {
        for (T fruit : list) {
            this.addFruitToBox(fruit);
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitList=" + fruitList +
                '}';
    }

    public float calcWeight() {
        float weight = 0f;
        for (T fruit : fruitList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        float diff = (this.calcWeight() - ((Box<?>) o).calcWeight()) * 100;
    //    System.out.println(diff);
        return (int) diff;
    }

    public boolean compareWithAnotherBox(Box<?> boxToCompare, float tolerance) {
        float result = (Math.abs(this.calcWeight() - (boxToCompare).calcWeight()));
        //   System.out.println(result + " vs " + tolerance);
        return result < tolerance;
    }

    public void transferringFruitToAnotherBox(Box<T> boxToTransfer) {
        //    boxToTransfer.getFruitList().addAll(fruitList);
        //    fruitList.removeAll(fruitList);

        //   for (T fruit : fruitList) {
        //       boxToTransfer.addFruitToBox(fruit);
        //   }

        for (int i = fruitList.size() - 1; i >= 0; i--) {
            // System.out.println("Индекс " + i + " Значение " + fruitList.get(i));
            boxToTransfer.addFruitToBox(fruitList.get(i));
            fruitList.remove(i);
        }
    }
}



