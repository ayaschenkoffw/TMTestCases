package PageElements;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.UUID;

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
    @FindBy (xpath = ".//*[@id='checkout-item-page']/div/div[3]")
    WebElement addToTheCartButton;
    public void clickOnAddToTheCartButton(){
        addToTheCartButton.click();
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
    public WebElement elementEmailFieldonCheckOutForm(){

        return emailFieldonCheckOutForm;
    }

    //Entering email address
    public void enterValueToEmailField(String choosePropertyHere){
        try{
            String userEmail = new Users().pullOutOfPropertiesFile("emailaddress", choosePropertyHere);
        emailFieldonCheckOutForm.sendKeys(UUID.randomUUID().toString() + userEmail);}
        catch (Exception e){}
    }

    //Method to paste any value from any Property field
    public void takeValueFromPropFilesandPasteIt(String propKey, String propFile, WebElement elementToPastePropFileInfo){
        try{String valuPulledFromFile = new Users().pullOutOfPropertiesFile(propKey, propFile);
//            valuPulledFromFile.getBytes("UTF-8");
           elementToPastePropFileInfo.sendKeys(valuPulledFromFile);}
        catch (Exception e){}
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


    //Open URL
    public void openURL(String urlHere) {
        driver.get(urlHere);
    }

    //Clear Field
    public  void clearField(WebElement elementToBeCleared){elementToBeCleared.clear();}
}
