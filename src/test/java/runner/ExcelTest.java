package runner;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.graalvm.compiler.word.Word;

import java.io.*;


public class ExcelTest {
    public static void main(String[] args) {
     File file=new File("");
        try {
            FileInputStream input=new FileInputStream(file);
            XSSFWorkbook workbook= null;
            try {
                workbook = new XSSFWorkbook(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            XSSFSheet excelSheet= workbook.getSheet("Sheet1");
           String value= excelSheet.getRow(0).getCell(0).toString();
            System.out.println(value);
            System.out.println(excelSheet.getRow(2).getCell(3));
            XSSFRow row = excelSheet.getRow(1);
            XSSFCell cell=row.getCell(2);
            System.out.println(cell);
           XSSFRow  row2=excelSheet.getRow(4);
            XSSFCell cell2=row2.createCell(3);
            cell2.setCellType(CellType.STRING);
            cell2.setCellValue("Miami");
            FileOutputStream fileOutputStream=new FileOutputStream("");
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
            System.out.println("Excel file does not exist!");
        } catch (IOException e) {

        }
    }
}
