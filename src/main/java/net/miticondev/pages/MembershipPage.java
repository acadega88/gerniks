package net.miticondev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='membershipStartDate']")
    private WebElement membershipStart;
    @FindBy(xpath = "//button[@aria-label='July 31, 2023']")
    private WebElement pickedStartDate;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    public MembershipPage(WebDriver driver) {
        super(driver);
    }

    public MembershipPage selectStartDate(){
        commands.clickElementJS(driver, membershipStart);
        commands.clickElement(driver, pickedStartDate);
        return this;
    }

    public PaymentPage clickNextButton(){
        commands.clickElement(driver, nextButton);
        return new PaymentPage(driver);
    }

}
