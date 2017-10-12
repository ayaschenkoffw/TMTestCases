package TestCases;

import PageElements.WebElementsPage;
import Waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageElements.WebElementsPage;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTestCase {
    WebDriver driver;
    Waiters wait;


    @BeforeMethod
    void addingTemplateToTheCart() throws Exception{
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElementsPage openURL = new WebElementsPage(driver);
        WebElementsPage clickOnElement = new WebElementsPage(driver);
        Waiters wait = new Waiters(driver);
        openURL.openURL("https://www.templatemonster.com");

        //Wait and click on first item in Products List
        wait.waitForElementToShowUp(clickOnElement.elementFirstItemOnProductsList());
        clickOnElement.clickOnFirstProductInTheList();

        //Wait and click on Add To Cart button
        wait.waitForElementToShowUp(clickOnElement.elementaddToTheCartButton());
        clickOnElement.clickOnAddToTheCartButton();

        Actions makeAction = new Actions(driver);
        makeAction.moveToElement(clickOnElement.elementcheckOutNowButton());

        //Wait and click on Check Out Now button
        wait.waitForElementToShowUp(clickOnElement.elementcheckOutNowButton());
        clickOnElement.clickonCheckOutButton();

    }
    @Test
    void test()throws Exception{
       // driver.get("https://www.templatemonster.com");
    }
}
