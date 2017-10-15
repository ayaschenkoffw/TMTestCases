package TestCases;

import PageElements.Users;
import PageElements.WebElementsPage;
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
import PageElements.WebElementsPage;
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
//        wait.waitForElementToBecomeClickable(clickOnElement.elementaddToTheCartButton());
//        wait.waitForElementToShowUp(clickOnElement.elementaddToTheCartButton());
//        wait.waitForElementToBecomeFullyLoaded(clickOnElement.elementaddToTheCartButton());
//        wait.waitForTextOnPage("Get It Now & You’ll Love It!", clickOnElement.elementaddToTheCartButton());
        Thread.sleep(5000);
        clickOnElement.clickOnAddToTheCartButton();

        //Wait and click on Check Out Now button
        wait.waitForElementToShowUp(clickOnElement.elementcheckOutNowButton());
        Thread.sleep(5000);
        clickOnElement.clickonCheckOutButton();

    }

    @Test (description = "User1")
    void User1RegistrationTestCase() throws Exception{
        WebElementsPage clickOnElement = new WebElementsPage(driver);
        Waiters wait = new Waiters(driver);
        Actions actions = new Actions(driver);

        //Waiting for e-mail filed and entering Email
        wait.waitForElementToBecomeClickable(clickOnElement.elementEmailFieldonCheckOutForm());
        clickOnElement.enterValueToEmailField("usaUser.properties");

        //Waiting for First name filed and entering first name
        wait.waitForElementToShowUp(clickOnElement.elementFullNameField());
        clickOnElement.takeValueFromPropFilesandPasteIt("username", "usaUser.properties", clickOnElement.elementFullNameField());

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

        //Entering Zip code
        clickOnElement.takeValueFromPropFilesandPasteIt("zipcode", "usaUser.properties", clickOnElement.elementZipCodeField());

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
        clickOnElement.clickOnSubmitButton();
        wait.waitForElementToShowUp(clickOnElement.elementPayPallButton());


    }
    @Test (description = "User2")
    void User2RegistrationTestCase() throws Exception{
        WebElementsPage clickOnElement = new WebElementsPage(driver);
        Waiters wait = new Waiters(driver);
        Actions actions = new Actions(driver);

        //Waiting for e-mail filed and entering Email
        wait.waitForElementToBecomeClickable(clickOnElement.elementEmailFieldonCheckOutForm());
        clickOnElement.enterValueToEmailField("ukraineUser.properties");

        //Waiting for First name filed and entering first name
        wait.waitForElementToShowUp(clickOnElement.elementFullNameField());
        clickOnElement.takeValueFromPropFilesandPasteIt("username", "ukraineUser.properties", clickOnElement.elementFullNameField());

        //Click on Country dropdown and Search for needed country
        clickOnElement.clickOnCountryDropdown();
        wait.waitForElementToBecomeClickable(clickOnElement.openedDropDown());
        clickOnElement.takeValueFromPropFilesandPasteIt("country", "ukraineUser.properties", clickOnElement.elementCountrySearchField());
        clickOnElement.elementCountrySearchField().sendKeys(Keys.ENTER);

        //Entering phone number
        clickOnElement.clickOnPhoneCountryDropDown();
        wait.waitForElementToBecomeClickable(clickOnElement.elementPhoneCountryDropDown());
        clickOnElement.takeValueFromPropFilesandPasteIt("country", "ukraineUser.properties", clickOnElement.elementSearchFieldCountryPhoneField());
        clickOnElement.elementSearchFieldCountryPhoneField().sendKeys(Keys.ENTER);
        clickOnElement.takeValueFromPropFilesandPasteIt("phone", "ukraineUser.properties", clickOnElement.elementPhoneNumberField());

        //Entering Zip code
        clickOnElement.takeValueFromPropFilesandPasteIt("zipcode", "ukraineUser.properties", clickOnElement.elementZipCodeField());
        clickOnElement.elementZipCodeField().sendKeys(Keys.ENTER);

//        //Entering State
//        clickOnElement.clickOnStateDrodown();
//        wait.waitForElementToShowUp(clickOnElement.elementOpenedStateDropdown());
//        clickOnElement.takeValueFromPropFilesandPasteIt("state", "ukraineUser.properties", clickOnElement.elementStateSearchField());
//        clickOnElement.elementStateSearchField().sendKeys(Keys.ENTER);
////        Thread.sleep(5000);
//
//        //Entering City
//        actions.click(clickOnElement.elementCityField());
//        clickOnElement.clearField(clickOnElement.elementCityField());
//        clickOnElement.takeValueFromPropFilesandPasteIt("city", "ukraineUser.properties", clickOnElement.elementCityField());

        //Click on Submit button and Waiting for BillingBlock
        clickOnElement.clickOnSubmitButton();
        wait.waitForElementToShowUp(clickOnElement.elementPayPallButton());

    }
    @AfterMethod
//    void takingScreenshot() throws Exception {
//        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String screenShotName = UUID.randomUUID().toString();
//        FileUtils.copyFile(screenShotFile, new File("src/test/resources/screenshots/"+screenShotName+".png"));
//
//    }
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }
}
