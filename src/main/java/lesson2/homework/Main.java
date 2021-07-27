package lesson2.homework;

public class Main {
    public static void main(String[] args) {
        String[][] arrOk = {
                {"12", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "45", "56", "67"},
                {"45", "56", "67", "78"}
        };

        String[][] arrFalseRows = {
                {"12", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "45", "56", "67"}
        };

        String[][] arrFalseCols = {
                {"12", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "45", "56", "67", "67", "67", "67"},
                {"45", "56", "67", "78"}
        };

        String[][] arrFalseData = {
                {"1", "23", "34", "45"},
                {"23", "34", "45", "56"},
                {"34", "$4*", "56", "67"},
                {"45", "56", "67", "78"}
        };

        System.out.println("Сумма всех элементов массива: " + sumArrowElements(arrOk));

        try {
            System.out.println("Сумма всех элементов массива: " + sumArrowElements(arrFalseRows));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Сумма всех элементов массива: " + sumArrowElements(arrFalseCols));
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
        if (inputArray.length != 4) {
            throw new MyArraySizeException("Ошибка в размерности массива: ожидается 4x4, фактически в массиве задано "
                    + inputArray.length + " строк(и)");
        }
        int sum = 0;
        int row = 0;
        int col;
        for (String[] rows : inputArray) {
            row++;
            col = 0;
            for (String colData : rows) {
                if (rows.length != 4) {
                    throw new MyArraySizeException
                            ("Ошибка в размерности массива: ожидается массив 4x4, фактически в массиве в "
                            + row + "-й строке задано " + rows.length + " столбц(ов/а)");
                }
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
