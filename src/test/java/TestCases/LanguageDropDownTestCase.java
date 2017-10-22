package TestCases;

import PageElements.DataProvider;
import PageElements.LangDropdownChecker;
import PageElements.Service;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LanguageDropDownTestCase {
    WebDriver driver;

    @Parameters({"browserType"})
    @BeforeMethod(alwaysRun = true)
    void firstOfAll(String browserType) throws Exception{

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
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1900, 1080));

        Service openURL = new Service(driver);
        openURL.openURL("https://www.templatemonster.com");
    }

    @Test(groups = {"userRegTestCase"},dataProvider = "languageList",dataProviderClass = DataProvider.class)
    void langDropDownTest(String langPicker)throws Exception{
        LangDropdownChecker langDropdownChecker = new LangDropdownChecker(driver);
        langDropdownChecker.languageDropDownCheck(langPicker);
    }
    @AfterMethod
    void closeBrowser()throws Exception{
        Service closeBrowser = new Service(driver);
        closeBrowser.closeBrowserWindow();
    }
}
