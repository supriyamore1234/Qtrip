package qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

public class LoginPage {
    WebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";
    String urlAfterLogin = "https://qtripdynamic-qa-frontend.vercel.app";
    String urlAfterLogout = "https://qtripdynamic-qa-frontend.vercel.app";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

    }

    @FindBy(xpath = "//a[text()='Login Now']")
    WebElement LoginNow;
    @FindBy(name = "email")
    WebElement LoginMail;
    @FindBy(name = "password")
    WebElement PasswordLogin;
    @FindBy(xpath = "//button[text()='Login to QTrip']")
    WebElement LoginQtrip;
    @FindBy(xpath = "//div[text()='Logout']")
    WebElement LogOutButton;
    @FindBy(xpath = "//a[contains(text(),'Login Here')]")
    WebElement LoginHere;

    public void LoginCheck() {
        try {
            LoginNow.click();
            SoftAssert sa = new SoftAssert();
            // Verify User NAvigatedTO LoginPAge
            sa.assertEquals(driver.getCurrentUrl(), url, "LoginNow is Not Clicked");
            if (!driver.getCurrentUrl().equals(url)) {
                driver.get(url);
            }
            // Enter Login Credentials
            LoginMail.sendKeys("sss@gmail.com");
            PasswordLogin.sendKeys("ssssss");
            // Click Button To LoginNow
            LoginQtrip.click();
            // verify user is loged in
            sa.assertNotEquals(driver.getCurrentUrl(), urlAfterLogin, "Lgin To Qtrip Button is Not Clicked");
            // Click OnLog Out Button
            LogOutButton.click();
            Thread.sleep(3000);
            // verify that user is Successfully Logged Out
            sa.assertTrue(LoginHere.isDisplayed(), "NOT Logged Out Successfully");
            sa.assertAll();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}