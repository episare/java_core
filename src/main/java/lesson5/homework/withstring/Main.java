package lesson5.homework.withstring;

import java.io.*;
import java.util.ArrayList;

import static lesson5.homework.withstring.MyConst.*;

public class Main {
    public static void main(String[] args) {
        String[] header = new String[]{"Value1", "Value2", "Value3"};
        String[][] intData = new String[][]{
                {"100", "200", "123"},
                {"300", "400", "500"}
        };
        AppData appData = new AppData(header, intData);
        String fileName = "appData.csv";

        System.out.println("Исходные данные:" + NEW_LINE + appData + NEW_LINE);

        // Пишем в appData.csv
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(appData.appDataAsStingForOutputCVS());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Читаем из appData.csv
        AppData appDataFromCSV = new AppData();
        ArrayList<String> stringArrayListFromCSV = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineFromCSV;
            while ((lineFromCSV = bufferedReader.readLine()) != null) {
                stringArrayListFromCSV.add(lineFromCSV);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        appDataFromCSV.setHeader(stringArrayListFromCSV.get(0).split(CVS_SPLIT));

        int sizeDataArray = stringArrayListFromCSV.size() - 1;
        String[][] arrayDataFromCSV = new String[sizeDataArray][];
        for (int i = 0; i < sizeDataArray; i++) {
            arrayDataFromCSV[i] = stringArrayListFromCSV.get(i + 1).split(CVS_SPLIT);
        }
        appDataFromCSV.setData(arrayDataFromCSV);
        System.out.println("Прочитанные данные:\n" + appDataFromCSV);
    }


}
