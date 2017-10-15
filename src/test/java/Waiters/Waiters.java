package Waiters;

import PageElements.WebElementsPage;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class Waiters {
    WebDriver driver;

    public Waiters (WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToShowUp(WebElement elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementLocator));
    }

    public void waitForElementToBecomeClickable(WebElement elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitForElementToBecomeFullyLoaded(WebElement elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeContains(elementLocator,"class","chosen-disabled"));
    }
    public void waitForTextOnPage(String textOnPage, WebElement elementWithNeededText){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(elementWithNeededText, textOnPage));
    }
}
