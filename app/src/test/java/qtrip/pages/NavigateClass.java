package qtrip.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateClass {
    WebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/";

    public NavigateClass(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate Method
    public void NavigateClass_() {
        try {
            if (!driver.getCurrentUrl().equals(url)) {
                driver.get(url);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
