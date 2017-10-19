package TestCases;

import PageElements.CookieChecker;
import PageElements.Service;
import Waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CookieVerificationTestCase {
    WebDriver driver;
    WebDriverWait wait;
    WebElement cookie;


    @BeforeMethod
    void firstOfAll() throws Exception{

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Service openURL = new Service(driver);
        openURL.openURL("https://www.templatemonster.com");
    }

    @Test
    void checkCookie()throws Exception{
        CookieChecker cookieTest = new CookieChecker(driver);
        cookieTest.cookieChecker("aff","TM");
    }

}
