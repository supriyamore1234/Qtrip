package qtrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Apachee {
    WebDriver driver;

    public Apachee(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();

    }

    public static Object[][] getRegisterData(String sheetname) throws IOException {
        Object[][] array = null;
        File file = new File("C:\\Users\\Sanket\\Desktop\\DatasetsforQTrip.xlsx");
        try {
            FileInputStream fi = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fi);
            Sheet sheet = workbook.getSheet(sheetname);
            // int rowcount = sheet.getPhysicalNumberOfRows();//
            int rowcount = sheet.getLastRowNum();
            ///
            int coloumncount = sheet.getRow(1).getLastCellNum();
            array = new Object[rowcount][coloumncount - 1];
            int ci, cj;
            ci = 0;
            for (int i = 1; i <= rowcount; i++, ci++) {

                Row row = sheet.getRow(i);
                cj = 0;
                for (int j = 1; j <= coloumncount; j++, cj++) {
                    Cell cell = row.getCell(j);
                    ///
                    if (cell != null) {
                        ////
                        switch (cell.getCellType()) {
                            case STRING:
                                array[ci][cj] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                array[ci][cj] = cell.getNumericCellValue();
                                break;
                            case BOOLEAN:
                                array[ci][cj] = cell.getBooleanCellValue();
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            System.out.println("array data is " + array);
            workbook.close();
            fi.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        Object[][] obj = getRegisterData("TestCase01");
        // System.out.println(obj);
        for (Object i[] : obj) {
            for (Object j : i) {
                System.out.println(j + " ");

            }
        }
    }
}
