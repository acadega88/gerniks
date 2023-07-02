package net.miticondev.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverCommands {

    public void isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException ignored) {
        }
    }

    public void clickElement(WebDriver driver, WebElement element) {
        waitForElementToBeVisible(driver, element);
        element.click();
    }

    public void type(WebDriver driver, WebElement element, String text) {
        waitForElementToBeVisible(driver, element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(text);
    }

    public String getTextFrom(WebDriver driver, WebElement element) {
        waitForElementToBeVisible(driver, element);
        return element.getText();
    }

    public void mouseHover(WebDriver driver, WebElement element) {
        waitForElementToBeVisible(driver, element);
        new Actions(driver).moveToElement(element).perform();
    }

    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElementJS(WebDriver driver, WebElement element) {
        waitForElementToBeVisible(driver, element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
