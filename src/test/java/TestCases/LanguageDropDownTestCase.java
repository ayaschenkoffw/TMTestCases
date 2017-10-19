package TestCases;

import PageElements.DataProvider;
import PageElements.LangDropdownChecker;
import PageElements.Service;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LanguageDropDownTestCase {
    WebDriver driver;

    @BeforeMethod
    void firstOfAll() throws Exception{

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1900, 1000));

        Service openURL = new Service(driver);
        openURL.openURL("https://www.templatemonster.com");
    }

    @Test(dataProvider = "languageList",dataProviderClass = DataProvider.class)
    void langDropDownTest(String langPicker)throws Exception{
        LangDropdownChecker langDropdownChecker = new LangDropdownChecker(driver);
        langDropdownChecker.languageDropDownCheck(langPicker);
    }
}
