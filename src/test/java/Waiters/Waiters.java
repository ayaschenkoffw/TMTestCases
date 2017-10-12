package Waiters;

import PageElements.WebElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    WebDriver driver;

    public Waiters (WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToShowUp(WebElement elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementLocator));
    }
}
