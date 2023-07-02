package net.miticondev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartTrainingPage extends BasePage {

    @FindBy(xpath = "(//button[@class='contract-btn'])[2]")
    private WebElement buyMembershipBtn;

    public StartTrainingPage(WebDriver driver) {
        super(driver);
    }

    public ContractPage buyMembership(){
        commands.waitForElementToBeVisible(driver, buyMembershipBtn);
        commands.clickElementJS(driver, buyMembershipBtn);
        return new ContractPage(driver);
    }

}
