package PageElements;

import Waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class FaceBookLoginOnPopUpPage {
    WebDriver driver;

    public FaceBookLoginOnPopUpPage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = ".//*[@type ='text']")
    WebElement loginField;
    public WebElement elementLoginField(){return loginField;}

    @FindBy (xpath = ".//*[@type ='password']")
    WebElement passwordField;
    public WebElement elementPasswordField(){return passwordField;}

    @FindBy (id = "loginbutton")
    WebElement fbLoginButton;
    public WebElement elementFBLoginButton(){return fbLoginButton;}

    public void facebookLoginDesktop() throws Exception{
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        Waiters wait = new Waiters(driver);
        HomePage hpElement = new HomePage(driver);
        try {
            fileInputStream = new FileInputStream("src/test/resources/fbLoginCredentials.properties");
            properties.load(new InputStreamReader(fileInputStream, "UTF-8"));
        }
        catch (Exception e){};

        elementLoginField().sendKeys(properties.getProperty("fblogin"));
        elementPasswordField().sendKeys(properties.getProperty("fbpassword"));
        elementFBLoginButton().click();
    }
}
