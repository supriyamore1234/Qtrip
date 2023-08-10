package qtrip.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import qtrip.pages.LoginPage;
import qtrip.pages.NavigateClass;
import qtrip.pages.RegisterPage;

public class TestCase02 {

    WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void DriverInitialization() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Before test");
    }

    @Test(priority = 1)
    public void NavigateToUrl() throws InterruptedException {
        // create object of navigateclass
        NavigateClass nv = new NavigateClass(driver);
        nv.NavigateClass_();
        Thread.sleep(3000);
        // Create object Of Registration Class To Click Register Button
        RegisterPage Rp = new RegisterPage(driver);
        Rp.Registeration();
        System.out.println("Durring Test");
        // Login Pgae Verification
        LoginPage Lp = new LoginPage(driver);
        Lp.LoginCheck();
    }

    @AfterSuite
    public void closeDriverMeth() {
        System.out.println("Quit Driver After Test");
        driver.quit();
    }
}
