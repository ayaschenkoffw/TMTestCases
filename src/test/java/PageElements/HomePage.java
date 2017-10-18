package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage (WebDriver driver) throws Exception{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    //First item in Products greed
    @FindBy(xpath = ".//*[@id='products']//li[1]")
    WebElement firstItemOnProductsList;
    public void clickOnFirstProductInTheList(){
        firstItemOnProductsList.click();
    }
    public WebElement elementFirstItemOnProductsList(){
        return firstItemOnProductsList;
    }

    @FindBy(id = "menu-favorites")
    WebElement favoriteIcon;

    public WebElement elementFavoriteIcon(){return favoriteIcon;}
}
