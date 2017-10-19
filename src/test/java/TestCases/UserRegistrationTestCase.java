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
        Service openURL = new Service(driver);
        HomePage homePageElement = new HomePage(driver);
        CheckOutPage checkOutPageElement = new CheckOutPage(driver);
        Waiters wait = new Waiters(driver);
        openURL.openURL("https://www.templatemonster.com");
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

    @Test (dataProvider = "pathList",dataProviderClass = DataProvider.class)
    void UserRegistrationTestCase(String pathPicker) throws Exception {

        RegistrationPage regPageElement = new RegistrationPage(driver);
        Users newUser = new Users(pathPicker);

        regPageElement.registerNewUser(newUser);
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
