package net.miticondev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[@class='step-left']")
    private WebElement contractInformation;
    @FindBy(xpath = "//button[text()='Start training']")
    private WebElement startTrainingBtn;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getContactInformation(){
        return commands.getTextFrom(driver, contractInformation);
    }

    public SubmitPage clickStartTraining(){
        commands.clickElement(driver, startTrainingBtn);
        return new SubmitPage(driver);
    }
}
