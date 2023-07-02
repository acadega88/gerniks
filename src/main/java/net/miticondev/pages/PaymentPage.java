package net.miticondev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='accountOwner']")
    private WebElement accountOwnerField;
    @FindBy(xpath = "//input[@formcontrolname='bankName']")
    private WebElement bankNameField;
    @FindBy(xpath = "//input[@formcontrolname='iban']")
    private WebElement ibanField;
    @FindBy(xpath = "//input[@formcontrolname='bic']")
    private WebElement bicField;
    @FindBy(xpath = "//span[@class='mat-radio-container'])[1]")
    private WebElement weeklyPayment;
    @FindBy(xpath = "//mat-select[@formcontrolname='weeklyDay']")
    private WebElement weeklyDropdown;
    @FindBy(xpath = "//span[text()=' Every Monday ']")
    private WebElement everyMonday;
    @FindBy(xpath = "//mat-select[@formcontrolname='paymentMethod']")
    private WebElement paymentMethod;
    @FindBy(xpath = "//span[text()=' Money transfer ']")
    private WebElement moneyTransfer;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage writeAccountOwner(String accOwner) {
        commands.type(driver, accountOwnerField, accOwner);
        return this;
    }
    public PaymentPage writeBankName(String bankName) {
        commands.type(driver, bankNameField, bankName);
        return this;
    }
    public PaymentPage writeIban(String iban) {
        commands.type(driver, ibanField, iban);
        return this;
    }
    public PaymentPage writeBic(String bic) {
        commands.type(driver, bicField, bic);
        return this;
    }

    public PaymentPage payment(){
        commands.clickElement(driver, weeklyPayment);
        commands.clickElement(driver, weeklyDropdown);
        commands.clickElement(driver, everyMonday);
        return this;
    }
    public void selectPaymentMethod() {
        commands.clickElement(driver, paymentMethod);
        commands.clickElement(driver, moneyTransfer);
    }

    public StartPage clickNextButton(){
        commands.clickElement(driver, nextButton);
        return new StartPage(driver);
    }
}
