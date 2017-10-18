package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage (WebDriver driver) throws Exception{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Add To Cart Button
    @FindBy(xpath = ".//*[@id='checkout-item-page']/div/div[3]")
    WebElement addToTheCartButton;
    public void clickOnAddToTheCartButton(){
        addToTheCartButton.click();
    }
    public WebElement elementAddToTheCartButton(){
        return addToTheCartButton;
    }

    //Checkout Button
    @FindBy (id = "cart-summary-checkout")
    public WebElement checkOutNowButton;
    public void clickonCheckOutButton(){
        checkOutNowButton.click();
    }
    public WebElement elementCheckOutNowButton(){
        return checkOutNowButton;
    }
}
