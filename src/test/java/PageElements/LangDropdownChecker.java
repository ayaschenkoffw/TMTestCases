package PageElements;

import Waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LangDropdownChecker {
    WebDriver driver;

    public LangDropdownChecker(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void languageDropDownCheck(String langPicker)throws Exception{
        HomePage languageDD = new HomePage(driver);
        Waiters wait = new Waiters(driver);
        languageDD.clickOnLanguageDropdown();
        wait.waitForElementToBecomeClickable(languageDD.elementLangDropDownBottom());
        driver.findElement(By.xpath(".//*[@id='menu-"+ langPicker + "-locale']")).click();
        wait.waitForNeededLangInURL(langPicker.toLowerCase());
    }
}
