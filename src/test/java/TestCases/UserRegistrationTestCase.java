package TestCases;

import PageElements.*;
import Waiters.Waiters;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Dim;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import PageElements.Users;

import javax.jws.soap.SOAPBinding;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTestCase {
    WebDriver driver;
    Waiters wait;


    @BeforeMethod
    void addingTemplateToTheCart() throws Exception {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1900, 1000));
        Method method = new Method(driver);
        HomePage homePageElement = new HomePage(driver);
        CheckOutPage checkOutPageElement = new CheckOutPage(driver);
        RegistrationPage regPageElement = new RegistrationPage(driver);
        Waiters wait = new Waiters(driver);
        method.openURL("https://www.templatemonster.com");
        Actions actions = new Actions(driver);

        //Wait and click on first item in Products List
        wait.waitForElementToShowUp(homePageElement.elementFirstItemOnProductsList());
        homePageElement.clickOnFirstProductInTheList();

        //Wait and click on Add To Cart button
        wait.waitForElementToShowUp(homePageElement.elementFavoriteIcon());
        Thread.sleep(5000);
        actions.moveToElement(checkOutPageElement.elementAddToTheCartButton());
        checkOutPageElement.clickOnAddToTheCartButton();

        //Wait and click on Check Out Now button
        wait.waitForElementToShowUp(checkOutPageElement.elementCheckOutNowButton());
        Thread.sleep(5000);
        checkOutPageElement.clickonCheckOutButton();

    }

    @Test (description = "User1")
    void User1RegistrationTestCase() throws Exception{
        Waiters wait = new Waiters(driver);
        Actions actions = new Actions(driver);
        Method method = new Method(driver);
        HomePage homePageElement = new HomePage(driver);
        CheckOutPage checkOutPageElement = new CheckOutPage(driver);
        RegistrationPage regPageElement = new RegistrationPage(driver);
        Users userUSA = new Users();
        userUSA.setValue("src/test/resources/usaUser.properties");

        //Waiting for e-mail filed and entering Email
        wait.waitForElementToBecomeClickable(regPageElement.elementEmailFieldonCheckOutForm());
        regPageElement.elementEmailFieldonCheckOutForm().sendKeys(userUSA.getEmailaddress());

        //Waiting for First name filed and entering first name
        wait.waitForElementToShowUp(regPageElement.elementFullNameField());
        regPageElement.elementFullNameField().sendKeys(userUSA.getName());

        //Click on Country dropdown and Search for needed country
        regPageElement.clickOnCountryDropdown();
        wait.waitForElementToBecomeClickable(regPageElement.openedDropDown());
        regPageElement.elementCountrySearchField().sendKeys(userUSA.getCountry());
        regPageElement.elementCountrySearchField().sendKeys(Keys.ENTER);

        //Entering phone number
        regPageElement.clickOnPhoneCountryDropDown();
        wait.waitForElementToBecomeClickable(regPageElement.elementPhoneCountryDropDown());
        regPageElement.elementSearchFieldCountryPhoneField().sendKeys(userUSA.getCountry());
        regPageElement.elementSearchFieldCountryPhoneField().sendKeys(Keys.ENTER);
        regPageElement.elementPhoneNumberField().sendKeys(userUSA.getPhone());

        //Entering Zip code
        regPageElement.elementZipCodeField().sendKeys(userUSA.getZipcode());

//        //Entering State
//        clickOnElement.clickOnStateDrodown();
//        wait.waitForElementToShowUp(clickOnElement.elementOpenedStateDropdown()); ///!!!! this one is correct
//        clickOnElement.takeValueFromPropFilesandPasteIt("state", "usaUser.properties", clickOnElement.elementStateSearchField());
//        clickOnElement.elementStateSearchField().sendKeys(Keys.ENTER);
////        Thread.sleep(5000);
//
//        //Entering City
//        clickOnElement.clearField(clickOnElement.elementCityField());
//        clickOnElement.takeValueFromPropFilesandPasteIt("city", "usaUser.properties", clickOnElement.elementCityField());

        //Click on Submit button and Waiting for BillingBlock
        regPageElement.clickOnSubmitButton();
        wait.waitForElementToShowUp(regPageElement.elementPayPallButton());
        Assert.assertNotNull(regPageElement.elementPayPallButton());


    }
    @Test (description = "User2")
    void User2RegistrationTestCase() throws Exception{
        Waiters wait = new Waiters(driver);
        Actions actions = new Actions(driver);
        Method method = new Method(driver);
        HomePage homePageElement = new HomePage(driver);
        CheckOutPage checkOutPageElement = new CheckOutPage(driver);
        RegistrationPage regPageElement = new RegistrationPage(driver);
        Users userUkraine = new Users();
        userUkraine.setValue("src/test/resources/ukraineUser.properties");

        //Waiting for e-mail filed and entering Email
        wait.waitForElementToBecomeClickable(regPageElement.elementEmailFieldonCheckOutForm());
        regPageElement.elementEmailFieldonCheckOutForm().sendKeys(userUkraine.getEmailaddress());

        //Waiting for First name filed and entering first name
        wait.waitForElementToShowUp(regPageElement.elementFullNameField());
        regPageElement.elementFullNameField().sendKeys(userUkraine.getName());

        //Click on Country dropdown and Search for needed country
        regPageElement.clickOnCountryDropdown();
        wait.waitForElementToBecomeClickable(regPageElement.openedDropDown());
        regPageElement.elementCountrySearchField().sendKeys(userUkraine.getCountry());
        regPageElement.elementCountrySearchField().sendKeys(Keys.ENTER);

        //Entering phone number
        regPageElement.clickOnPhoneCountryDropDown();
        wait.waitForElementToBecomeClickable(regPageElement.elementPhoneCountryDropDown());
        regPageElement.elementSearchFieldCountryPhoneField().sendKeys(userUkraine.getCountry());
        regPageElement.elementSearchFieldCountryPhoneField().sendKeys(Keys.ENTER);
        regPageElement.elementPhoneNumberField().sendKeys(userUkraine.getPhone());

        //Entering Zip code
        regPageElement.elementZipCodeField().sendKeys(userUkraine.getZipcode());

//        //Entering State
//        clickOnElement.clickOnStateDrodown();
//        wait.waitForElementToShowUp(clickOnElement.elementOpenedStateDropdown()); ///!!!! this one is correct
//        clickOnElement.takeValueFromPropFilesandPasteIt("state", "usaUser.properties", clickOnElement.elementStateSearchField());
//        clickOnElement.elementStateSearchField().sendKeys(Keys.ENTER);
////        Thread.sleep(5000);
//
//        //Entering City
//        clickOnElement.clearField(clickOnElement.elementCityField());
//        clickOnElement.takeValueFromPropFilesandPasteIt("city", "usaUser.properties", clickOnElement.elementCityField());

        //Click on Submit button and Waiting for BillingBlock
        regPageElement.clickOnSubmitButton();
        wait.waitForElementToShowUp(regPageElement.elementPayPallButton());
        Assert.assertNotNull(regPageElement.elementPayPallButton());


    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }
}
