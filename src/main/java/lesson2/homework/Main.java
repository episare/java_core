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

//            Урок 2. Исключения
//
//            1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
//                При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//            2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//                Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ
//                или текст вместо числа), надо бросить исключение MyArrayDataException с детализацией,
//                в какой ячейке неверные данные.
//            3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
//                и MyArrayDataException и вывести результат расчета.
}
