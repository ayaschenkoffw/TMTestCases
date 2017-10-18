package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Method {
    WebDriver driver;

    public Method(WebDriver driver) throws Exception {
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

    //Method to paste any value from any Property field
    public void takeValueFromPropFilesandPasteIt(String propKey, String propFile, WebElement elementToPastePropFileInfo) {
        try {
            String valuPulledFromFile = new Users().pullOutOfPropertiesFile(propKey, propFile);
            elementToPastePropFileInfo.sendKeys(valuPulledFromFile);
        } catch (Exception e) {}
    }
}