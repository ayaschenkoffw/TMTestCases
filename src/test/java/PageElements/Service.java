package PageElements;

import Waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Service {
    WebDriver driver;

    public Service (WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Open URL
    public void openURL(String urlHere) {
        driver.get(urlHere);
    }

    //Clear Field
    public void clearField(WebElement elementToBeCleared) {
        elementToBeCleared.clear();
    }

    //Close Browser
    public void closeBrowserWindow(){
        driver.quit();
    }

    public void addingItemToTheCart(String browserType) throws Exception{

        if(browserType.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        }
        else if (browserType.equalsIgnoreCase("chrome")){
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        }
        else {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Service openURL = new Service(driver);
        openURL.openURL("https://www.templatemonster.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
//        HomePage homePageElement = new HomePage(driver);
//        CheckOutPage checkOutPageElement = new CheckOutPage(driver);
//        Waiters wait = new Waiters(driver);
//        Actions actions = new Actions(driver);
//
//        //Wait and click on first item in Products List
//        wait.waitForElementToShowUp(homePageElement.elementFirstItemOnProductsList());
//        homePageElement.clickOnFirstProductInTheList();
//
//        //Wait and click on Add To Cart button
//        wait.waitForElementToShowUp(homePageElement.elementFavoriteIcon());
//        Thread.sleep(5000);
//        actions.moveToElement(checkOutPageElement.elementAddToTheCartButton());
//        checkOutPageElement.clickOnAddToTheCartButton();
//
//        //Wait and click on Check Out Now button
//        wait.waitForElementToShowUp(checkOutPageElement.elementCheckOutNowButton());
//        Thread.sleep(5000);
//        checkOutPageElement.clickonCheckOutButton();

    }

}