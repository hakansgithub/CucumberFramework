package runner;

import com.sun.org.omg.CORBA.ExcDescriptionSeqHelper;
import utilities.ExcelUtils;

import java.io.IOException;

public class ExcelTest2 {

    public static void main (String[] args) throws IOException {
        ExcelUtils.openExcelFile("testData", "Sheet1");
        System.out.println(ExcelUtils.getValue(1, 1));
        System.out.println(ExcelUtils.getValue(2, 2));
        ExcelUtils.setValue("New York", 4, 3);
        ExcelUtils.setValue("20", 4, 4);
        for (int row = 1; row <= ExcelUtils.getNumberOfRows(); row++) {
            String age = ExcelUtils.getValue(row, 4);
            double ageInt = Double.parseDouble(age);
            ExcelUtils.setValue((ageInt + 1) + "", row, 4);
        }
    }
}
