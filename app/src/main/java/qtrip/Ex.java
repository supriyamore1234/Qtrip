package qtrip;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Ex extends Exercise {

    public Ex(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public static void screenshotType3(String outputtype, String description) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
        String timestamp = datetime.format(new Date());
        // File dest = new File("./takenewscreenshots" + timestamp + outputtype +
        // description + ".jpg");
        File dest = new File(
                System.getProperty("user.dir") + "/takenewscreenshots" + timestamp + outputtype + description + ".jpg");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void fullSceenshots() {
        // Capture a full webpage screenshot using Fpsc
        driver.get("https://web-locators-static-site-qa.vercel.app/Screenshot");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd__hh.mm.ss");
        String timestamp = dt.format(new Date()) + ".png";
        WebElement AUTButton = driver.findElement(By.xpath("//a[@href='https://www.crio.do/']"));
        AUTButton.click();
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("newscreenshot" + timestamp));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exercise ex = new Ex(driver);
        ex.navigateMethod();
        screenshotType3("demo", "screenshot");
        fullSceenshots();
        driver.quit();
    }

}
