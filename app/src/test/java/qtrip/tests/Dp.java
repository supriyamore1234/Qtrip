package qtrip.tests;

import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Dp {

    WebDriver driver;

    public Dp(WebDriver driver) {
        this.driver = driver;
    }

    FileInputStream fi;
    String path = "C://Users//Sanket//Desktop//DatasetsforQTrip.xlsx";
    Workbook workbook;
    XSSFSheet sheet;
    Row row;
    Cell cell;
    Object[][] array = null;

    public Object[][] getData(String sheetname) {
        try {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            sheet = (XSSFSheet) workbook.getSheet(sheetname);

            // TODO:
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
