package PageElements;

import Waiters.Waiters;
import com.sun.deploy.util.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CookieChecker {
    WebDriver driver;

    public CookieChecker(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void cookieChecker(String cookieNameHere, String expectedValueOfCookie) throws Exception{
        Waiters wait = new Waiters(driver);
        wait.waitForCookie(cookieNameHere);
        String valueOfCookie = driver.manage().getCookieNamed(cookieNameHere).getValue();

        Assert.assertEquals(valueOfCookie, expectedValueOfCookie);
    }
}
