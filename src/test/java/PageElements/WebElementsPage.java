package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementsPage {
    WebDriver driver;

    public WebElementsPage (WebDriver driver) throws Exception{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    //First item in Products greed
    @FindBy (xpath = ".//*[@id='products']//li[1]")
    WebElement firstItemOnProductsList;
    public void clickOnFirstProductInTheList(){
        firstItemOnProductsList.click();
    }
    public WebElement elementFirstItemOnProductsList(){
        return firstItemOnProductsList;
    }

    //Add To Cart Button
    @FindBy (xpath = ".//*[@id='checkout-item-page']/div[1]/div[3]")
    WebElement addToTheCartButton;
    public void clickOnAddToTheCartButton(){
        addToTheCartButton.submit();
    }
    public WebElement elementaddToTheCartButton(){
        return addToTheCartButton;
    }

    //Checkout Button
    @FindBy (id = "cart-summary-checkout")
    public WebElement checkOutNowButton;
    public void clickonCheckOutButton(){
        checkOutNowButton.click();
    }
    public WebElement elementcheckOutNowButton(){
        return checkOutNowButton;
    }



    //Email For on Checkout form
    @FindBy (id = "signin3-form-email")
    WebElement emailFieldonCheckOutForm;
    public void clickOnEmailForm(){
        emailFieldonCheckOutForm.click();
    }

    //Continue button near email field
    @FindBy (id="signin3-new-customer")
    WebElement continueButtonOnCheckOutForm;
    public void clickOnContinueButtonOnCjeckOutForm(){
        continueButtonOnCheckOutForm.click();
    }

    //Full name field
    @FindBy (id="billinginfo3-form-fullname")
    WebElement fullNameField;
    public void clickOnFullNameField(){
        fullNameField.click();
    }

    //Country Dropdown
    @FindBy (id="billinginfo3_form_countryiso2_chosen")
    WebElement countryDropdown;
    public void clickOnCountryDropdown(){
        countryDropdown.click();
    }

    //Phone Number
    @FindBy (id="billinginfo3-form-phone")
    WebElement phoneNumberField;
    public void clickOnPhoneNumberField(){
        phoneNumberField.click();
    }

    //Zip code field
    @FindBy (id="billinginfo3-form-postalcode")
    WebElement zipCodeField;
    public void clickOnZipCodeField(){
        zipCodeField.click();
    }

    //State dropdown
    @FindBy (id="billinginfo3_form_stateiso2_chosen")
    WebElement stateDrodown;
    public void clickOnStateDrodown(){
        stateDrodown.click();
    }

    //City field
    @FindBy (id="billinginfo3-form-cityname")
    WebElement cityField;
    public void clickOnCityField(){
        cityField.click();
    }
    //

    public void openURL(String urlHere) {
        driver.get(urlHere);
    }



}
