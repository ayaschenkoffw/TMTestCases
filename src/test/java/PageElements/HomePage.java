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

    //Favorites icon
    @FindBy(id = "menu-favorites")
    WebElement favoriteIcon;
    public WebElement elementFavoriteIcon(){return favoriteIcon;}

    //Language Dropdown
    @FindBy(xpath = ".//*[@id='header']/div[2]/ul/li[1]/span")
    WebElement langDropdown;
    public void clickOnLanguageDropdown() { langDropdown.click(); }

    //SE lang icon
    @FindBy (xpath = ".//*[@id='menu-SE-locale']")
    WebElement langDropDownBottom;
    public WebElement elementLangDropDownBottom(){return langDropDownBottom;}

    //Log in link
    @FindBy (id = "header-signin-link")
    WebElement accountButton;
    public WebElement elementAccountButton(){return accountButton;}

    //FB button
    @FindBy (xpath = ".//*[@id='id-general-facebook-button']/button")
    WebElement fbButton;
    public WebElement elementFBbutton(){return fbButton;}

    //Logged in user menu
    @FindBy (xpath = ".//*[@id='app-account-menu']")
    WebElement loggedInUserIcon;
    public WebElement elementLoggedInUser(){return loggedInUserIcon;}

    //Template price
    @FindBy (xpath = ".//*[@class = 'template-item-price']/div/span/span")
    WebElement temaplatePriceIcon;
    public WebElement getTemaplatePriceIcon() { return temaplatePriceIcon; }

    //Best sellers block
    @FindBy (id = "tab-bestseller")
    WebElement bestsellersblock;
    public WebElement elementBestsellersBlock(){return bestsellersblock;}

}
