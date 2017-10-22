package TestCases;

import PageElements.CookieChecker;
import PageElements.Service;
import Waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CookieVerificationTestCase {
    WebDriver driver;
    WebDriverWait wait;
    WebElement cookie;

    @Parameters({"browserType"})
    @BeforeMethod(alwaysRun = true)
    void firstOfAll(String browserType) throws Exception{

        Service test = new Service(driver);
        test.addingItemToTheCart(browserType);

//        if(browserType.equalsIgnoreCase("firefox")) {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
//        }
//        else if (browserType.equalsIgnoreCase("chrome")){
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
//        }
//        else {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        Service openURL = new Service(driver);
//        openURL.openURL("https://www.templatemonster.com");
    }

    @Test(groups = {"userRegTestCase"})
    void checkCookie()throws Exception{
        CookieChecker cookieTest = new CookieChecker(driver);
        cookieTest.cookieChecker("aff","TM");
    }
    @AfterMethod
    void closeBrowser()throws Exception{
        Service closeBrowser = new Service(driver);
        closeBrowser.closeBrowserWindow();
    }

}
