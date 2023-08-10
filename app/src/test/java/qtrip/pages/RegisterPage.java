package qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

public class RegisterPage {

    WebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";

    // constructor initialization of webe
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//a[@class='nav-link login register']")
    WebElement RegisterButton;
    @FindBy(name = "email")
    WebElement RegisterEmail;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(name = "confirmpassword")
    WebElement confirmPassword;
    @FindBy(xpath = "//button[text()='Register Now']")
    WebElement ButtonRegisterNow;

    public void Registeration() throws InterruptedException {
        try {
            RegisterButton.click();
            Thread.sleep(2000);
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(driver.getCurrentUrl().equals(url), "Regestration button is not clicked");

            RegisterEmail.sendKeys("sss@gmail.com");

            password.sendKeys("ssssss");

            confirmPassword.sendKeys("ssssss");
            ButtonRegisterNow.click();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
    }
}
