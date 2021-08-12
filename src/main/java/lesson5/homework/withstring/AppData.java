package lesson5.homework.withstring;

import java.util.Arrays;

import static lesson5.homework.withstring.MyConst.*;

public class AppData {
    private String[] header;
    private String[][] data;

    public AppData() {
    }

    public AppData(String[] header, String[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.deepToString(getData()) +
                '}';
    }

    public String appDataAsStingForOutputCVS() {
        String returnData = arrayToStringForOutputCVS(header);
        for (int i = 0; i < data.length; i++) {
            returnData += NEW_LINE + arrayToStringForOutputCVS(data[i]);
        }
        return returnData;
    }

    private String arrayToStringForOutputCVS(Object[] array) {
        return Arrays.toString(array).replaceAll("[\\[ \\]]", EMPTY_STRING).replace(ARRAY_SPLIT, CVS_SPLIT);
    }
}

