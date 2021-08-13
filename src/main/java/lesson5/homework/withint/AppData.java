package lesson5.homework.withint;

import java.util.Arrays;

import static lesson5.homework.withint.MyConst.*;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {
    }

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.deepToString(getData()) +
                '}';
    }

    public String appDataAsStingForOutputCVS() {
        String returnData = arrayToStringForOutputCVS(header);
        for (int[] dataLine : data) {
            returnData += NEW_LINE + arrayToStringForOutputCVS(intArrayToStringArray(dataLine));
        }
        return returnData;
    }

    private String arrayToStringForOutputCVS(Object[] array) {
        return Arrays.toString(array).replaceAll("[\\[ \\]]", EMPTY_STRING).replace(ARRAY_SPLIT, CVS_SPLIT);
    }

    private static String[] intArrayToStringArray(int[] intArray) {
        String[] stringArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            stringArray[i] = Integer.valueOf(intArray[i]).toString();
        }
        return stringArray;
    }
}

