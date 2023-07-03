package net.miticondev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitPage extends BasePage {

    @FindBy(xpath = "//div[@class='contract-submit-content']")
    private WebElement submitContent;

    public SubmitPage(WebDriver driver) {
        super(driver);
    }

    public String getSubmitContent(){
        return commands.getTextFrom(driver, submitContent);
    }
}
