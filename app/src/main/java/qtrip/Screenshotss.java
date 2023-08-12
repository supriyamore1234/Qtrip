package qtrip;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class Screenshotss {
    static WebDriver driver;
    static String url = "https://www.google.co.in/";

    public Screenshotss(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.driver = driver;
        driver.manage().window().maximize();

    }

    public void NN() {
        try {
            if (!driver.getCurrentUrl().equals(url))
                driver.get(url);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void screenshotMethod(String describtiob) {
        File fff = new File("FileForScreenshot");
        try {
            if (!fff.exists()) {
                fff.mkdirs();
            }
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat sd = new SimpleDateFormat("yyyy.mm.dd_hh.mm.ss");
            String timestamp = sd.format(new Date()) + ".png";
            File dest = new File(System.getProperty("user.dir") + "./FileForScreenshot" + describtiob + timestamp);

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void fullscreenshotMethod() {
        // try {
        // Screenshot Screenshot = new
        // AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
        // .takeScreenshot(driver);
        // SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd__hh.mm.ss");
        // String timestamp = dt.format(new Date()) + ".png";

        // ImageIO.write(Screenshot.getImage(), "PNG", new File("newscreenshot" +
        // timestamp));
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        try {
            SimpleDateFormat si = new SimpleDateFormat("yyyy.MM.dd__HH.mm.ss");
            String timestamp = si.format(new Date()) + ".png";
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "PNG",
                    new File("C:\\Users\\Sanket\\Desktop\\QTrip\\FileForScreenshot" + timestamp));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        Screenshotss ss = new Screenshotss(driver);
        ss.NN();
        // ss.screenshotMethod("demo");
        ss.fullscreenshotMethod();
        driver.close();
    }
}
