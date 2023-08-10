package qtrip;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Exercise {
    static WebDriver driver;
    static String url = "https://qtripdynamic-qa-frontend.vercel.app/";

    public Exercise(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.driver = driver;
        driver.manage().window().maximize();

    }

    public void navigateMethod() {
        try {
            if (!driver.getCurrentUrl().equals(url))
                driver.get(url);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void takeScreenshot2(WebDriver driver, String screenshotType, String description) throws IOException {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
            String timestamp = sdf.format(new Date());

            // System.out.println("Print file name" + fileName);

            File DestFile = new File("./newscreenshots/" + timestamp + screenshotType + description + ".png");
            FileUtils.copyFile(SrcFile, DestFile);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void fullScreenshot() throws IOException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd__hh.mm.ss");
        String timestamp = dt.format(new Date()) + "fullscreenshot.png";
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "PNG", new File("./takenewscreenshots" + timestamp));
    }

    public static void main(String[] args) throws IOException {
        Exercise ex = new Exercise(driver);
        ex.navigateMethod();
        // takeScreenshot2(driver, "yes", "ll");
        fullScreenshot();
        driver.close();
        driver.quit();
    }
}