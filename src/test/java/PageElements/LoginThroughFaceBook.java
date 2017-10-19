package PageElements;

import Waiters.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;

public class LoginThroughFaceBook {
    WebDriver driver;

    public LoginThroughFaceBook (WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void loginThroughFaceBook() throws Exception {
    HomePage elementHP = new HomePage(driver);
    Actions action = new Actions(driver);
    Waiters wait = new Waiters(driver);

    wait.waitForElementToBecomeClickable(elementHP.elementFavoriteIcon());
    elementHP.accountButton.click();

    for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String parentsHandle = driver.getWindowHandle();
        elementHP.elementFBbutton().click();

    for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        FaceBookLoginOnPopUpPage loginAction = new FaceBookLoginOnPopUpPage(driver);
        loginAction.facebookLoginDesktop();

    for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        wait.waitForElementToShowUp(elementHP.elementLoggedInUser());
    }
}
