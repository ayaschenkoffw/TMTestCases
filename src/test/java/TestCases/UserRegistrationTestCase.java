package TestCases;

import PageElements.Users;
import PageElements.WebElementsPage;
import Waiters.Waiters;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Dim;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageElements.WebElementsPage;
import org.openqa.selenium.interactions.Actions;
import PageElements.Users;

import javax.jws.soap.SOAPBinding;
import java.awt.*;
import java.net.URL;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTestCase {
    WebDriver driver;
    Waiters wait;


    @BeforeMethod
    void addingTemplateToTheCart() throws Exception{
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1900, 1000));
        WebElementsPage openURL = new WebElementsPage(driver);
        WebElementsPage clickOnElement = new WebElementsPage(driver);
        Waiters wait = new Waiters(driver);
        openURL.openURL("https://www.templatemonster.com");
        Actions actions = new Actions(driver);

        //Wait and click on first item in Products List
        wait.waitForElementToShowUp(clickOnElement.elementFirstItemOnProductsList());
        clickOnElement.clickOnFirstProductInTheList();

        //Wait and click on Add To Cart button
        actions.moveToElement(clickOnElement.elementaddToTheCartButton());
        wait.waitForElementToBecomeClickable(clickOnElement.elementaddToTheCartButton());
//        wait.waitForElementToShowUp(clickOnElement.elementaddToTheCartButton());
        Thread.sleep(5000);
        clickOnElement.clickOnAddToTheCartButton();

        //Wait and click on Check Out Now button
//        Thread.sleep(5000);
        wait.waitForElementToShowUp(clickOnElement.elementcheckOutNowButton());
//        Thread.sleep(5000);
        clickOnElement.clickonCheckOutButton();
//        Thread.sleep(5000);

        //Waiting for e-mail filed and entering Email
//        wait.waitForElementToShowUp(clickOnElement.elementEmailFieldonCheckOutForm());
        wait.waitForElementToBecomeClickable(clickOnElement.elementEmailFieldonCheckOutForm());
        clickOnElement.enterValueToEmailField("usaUser.properties");

        //Waiting for First name filed and entering first name
        wait.waitForElementToShowUp(clickOnElement.elementFullNameField());
        clickOnElement.takeValueFromPropFilesandPasteIt("username","usaUser.properties", clickOnElement.elementFullNameField());

        //Click on Country dropdown and Search for needed country
        clickOnElement.clickOnCountryDropdown();
        wait.waitForElementToBecomeClickable(clickOnElement.openedDropDown());
        clickOnElement.takeValueFromPropFilesandPasteIt("country", "usaUser.properties", clickOnElement.elementCountrySearchField());
        clickOnElement.elementCountrySearchField().sendKeys(Keys.ENTER);

        //Entering phone number
        clickOnElement.clickOnPhoneCountryDropDown();
        wait.waitForElementToBecomeClickable(clickOnElement.elementPhoneCountryDropDown());
        clickOnElement.takeValueFromPropFilesandPasteIt("country", "usaUser.properties", clickOnElement.elementSearchFieldCountryPhoneField());
        clickOnElement.elementSearchFieldCountryPhoneField().sendKeys(Keys.ENTER);
        clickOnElement.takeValueFromPropFilesandPasteIt("phone", "usaUser.properties", clickOnElement.elementPhoneNumberField());
//        clickOnElement.elementPhoneNumberField().sendKeys(Keys.ENTER);
//        clickOnElement.takeValueFromPropFilesandPasteIt();



    }
    @Test
    void test()throws Exception{
        driver.manage().window().fullscreen();

    }
}
