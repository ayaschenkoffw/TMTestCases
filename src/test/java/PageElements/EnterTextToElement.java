package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EnterTextToElement {
    WebDriver driver;

    public EnterTextToElement (WebDriver driver) throws Exception{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




}