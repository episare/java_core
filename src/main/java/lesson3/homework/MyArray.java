package lesson3.homework;

import java.util.Arrays;

public class MyArray<T> {
    private T[] array;

    @SafeVarargs
    public MyArray(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public void swapTwoElements(int firstElement, int secondElement) {
        T tempElement;

        if (array.length < firstElement || array.length < secondElement) {
            System.out.println("Заданные параметры " + firstElement + "," + secondElement
                    + "  выходят за пределы массива, длина массива " + array.length);
        } else {
            firstElement--;
            secondElement--;
            tempElement = array[firstElement];
            array[firstElement] = array[secondElement];
            array[secondElement] = tempElement;
        }
    }

    public static void main(String[] args) {
        MyArray<Object> myArray = new MyArray<>(1, "two", 3.0);

        System.out.println("Before swap: " + myArray);
        myArray.swapTwoElements(2,3);
        System.out.println("After swap: " + myArray);
    }
}

