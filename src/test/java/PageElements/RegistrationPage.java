package PageElements;

import Waiters.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.UUID;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage (WebDriver driver) throws Exception{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Email For on Checkout form
    @FindBy(id = "signin3-form-email")
    WebElement emailFieldonCheckOutForm;

    public WebElement elementEmailFieldonCheckOutForm(){

        return emailFieldonCheckOutForm;
    }

    //Full name field
    @FindBy (id="billinginfo3-form-fullname")
    WebElement fullNameField;
    public WebElement elementFullNameField(){
        return fullNameField;
    }

    //Country Dropdown
    @FindBy (id="billinginfo3_form_countryiso2_chosen")
    WebElement countryDropdown;
    public void clickOnCountryDropdown(){
        countryDropdown.click();
    }

    //Opened Dropdown
    @FindBy (xpath = ".//*[@class = 'chosen-drop']")
    WebElement openedDropDown;
    public WebElement openedDropDown(){
        return openedDropDown;
    }

    //Country Search Field
    @FindBy (xpath = ".//*[@class = 'chosen-search']/input")
    WebElement countrySearchField;
    public WebElement elementCountrySearchField(){
        return countrySearchField;}

    //Phone DropDown
    @FindBy (xpath = ".//*[@id = 'billinginfo3_form_phone_code_chosen']//*[@class = 'chosen-single']")
    WebElement phoneCountrydropDown;
    public void clickOnPhoneCountryDropDown(){phoneCountrydropDown.click();}

    public WebElement elementPhoneCountryDropDown(){return phoneCountrydropDown;}

    //Phone Number
    @FindBy (id="billinginfo3-form-phone")
    WebElement phoneNumberField;
    public WebElement elementPhoneNumberField(){return phoneNumberField;}

    @FindBy (xpath = ".//*[@id = 'billinginfo3_form_phone_code_chosen']//*[@class = 'chosen-drop']//*[@class = 'chosen-search']/input")
    WebElement searchFieldCountryPhoneField;
    public WebElement elementSearchFieldCountryPhoneField(){
        return searchFieldCountryPhoneField;
    }

    //Zip code field
    @FindBy (id="billinginfo3-form-postalcode")
    WebElement zipCodeField;
    public void clickOnZipCodeField(){
        zipCodeField.click();
    }

    public WebElement elementZipCodeField(){return zipCodeField;}

    //State dropdown
    @FindBy (id="billinginfo3_form_stateiso2_chosen")
    WebElement stateDropdown;
    public void clickOnStateDrodown(){
        stateDropdown.click();
    }

    @FindBy (xpath = ".//*[@id = 'billinginfo3_form_stateiso2_chosen']//*[@class = 'chosen-drop']")
    WebElement openedSatetDropDown;
    public WebElement elementOpenedStateDropdown(){return openedSatetDropDown;}

    public WebElement elementStateDroDown(){return stateDropdown;}

    @FindBy (xpath = ".//*[@id = 'billinginfo3_form_stateiso2_chosen']//*[@class = 'chosen-drop']//*[@class = 'chosen-search']/input")
    WebElement stateSearchField;

    public WebElement elementStateSearchField(){return stateSearchField;}

    //City field
    @FindBy (id="billinginfo3-form-cityname")
    WebElement cityField;
    public void clickOnCityField(){
        cityField.click();
    }

    public WebElement elementCityField(){return cityField;}

    //Submit button
    @FindBy (id = "billinginfo3-form-submit")
    WebElement submitButton;
    public void clickOnSubmitButton(){submitButton.click();}

    //PayPall button
    @FindBy (id = "checkout-payment-buy-PayPal")
    WebElement payPallButton;
    public WebElement elementPayPallButton(){return payPallButton;}

    public void registerNewUser(Users users){
        Waiters wait = new Waiters(driver);
        wait.waitForElementToBecomeClickable(elementEmailFieldonCheckOutForm());
        emailFieldonCheckOutForm.sendKeys(users.getEmailaddress());
        wait.waitForElementToShowUp(elementFullNameField());
        fullNameField.sendKeys(users.getName());
        clickOnCountryDropdown();
        wait.waitForElementToBecomeClickable(openedDropDown());
        elementCountrySearchField().sendKeys(users.getCountry());
        elementCountrySearchField().sendKeys(Keys.ENTER);
        clickOnPhoneCountryDropDown();
        wait.waitForElementToBecomeClickable(elementPhoneCountryDropDown());
        elementSearchFieldCountryPhoneField().sendKeys(users.getCountry());
        elementSearchFieldCountryPhoneField().sendKeys(Keys.ENTER);
        elementPhoneNumberField().sendKeys(users.getPhone());
        elementZipCodeField().sendKeys(users.getZipcode());
        clickOnSubmitButton();
        wait.waitForElementToShowUp(elementPayPallButton());
        Assert.assertNotNull(elementPayPallButton());


    }
}
