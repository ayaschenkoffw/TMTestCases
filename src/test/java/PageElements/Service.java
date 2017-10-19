package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

}