package lesson2.homework;

public class Main {
    public static void main(String[] args) {
        String[][] arrOk = {
                {"12", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "45", "56", "67"},
                {"45", "56", "67", "78"}
        };

        String[][] arrFalseSize = {
                {"12", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "45", "56", "67"}
        };

        String[][] arrFalseData = {
                {"1", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "$4*", "56", "67"},
                {"45", "56", "67", "78"}
        };

        System.out.println("Сумма всех элементов массива: " + sumArrowElements(arrOk));

        try {
            System.out.println("Сумма всех элементов массива: " + sumArrowElements(arrFalseSize));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Сумма всех элементов массива: " + sumArrowElements(arrFalseData));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumArrowElements(String[][] inputArray) throws MyArraySizeException, MyArrayDataException {
        if (inputArray.length != 4 | inputArray[0].length != 4) {
            throw new MyArraySizeException("Ошибка в размерности массива: ожидается 4x4, фактически задано "
                    + inputArray.length + "х" + inputArray[0].length);
        }
        int sum = 0;
        int row = 0;
        int col;
        for (String[] rows : inputArray) {
            row++;
            col = 0;
            for (String colData : rows) {
                col++;
                try {
                    sum += Integer.parseInt(colData);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в формате данных в строке "
                            + row + " столбец " + col + " : ожидается число, фактически задано "
                            + colData);
                }
            }
        }
        return sum;
    }
}
