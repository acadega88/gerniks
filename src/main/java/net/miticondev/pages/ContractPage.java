package net.miticondev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    private WebElement inputLastName;
    @FindBy(xpath = "//mat-select[@formcontrolname='gender']")
    private WebElement genderDropdown;
    @FindBy(xpath = "//span[text()=' Male ']")
    private WebElement genderMaleDropdown;
    @FindBy(xpath = "//span[text()=' Female ']")
    private WebElement genderFemaleDropdown;
    @FindBy(xpath = "//span[text()=' Prefer not to say ']")
    private WebElement genderNotSayDropdown;
    @FindBy(xpath = "//input[@formcontrolname='birthday']")
    private WebElement inputBirthday;
    @FindBy(xpath = "//button[@aria-label='July 1, 2023']")
    private WebElement pickedBirthday;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@formcontrolname='telephone']")
    private WebElement inputTelephone;

    @FindBy(xpath = "//input[@formcontrolname='emgName']")
    private WebElement inputEmgName;

    @FindBy(xpath = "//input[@formcontrolname='emgLastName']")
    private WebElement inputEmgLastName;

    @FindBy(xpath = "//input[@formcontrolname='emgPhoneNumber']")
    private WebElement inputEmgPhoneNumber;

    @FindBy(xpath = "//mat-select[@formcontrolname='emgRelationCd']")
    private WebElement emgRelationDropdown;

    @FindBy(xpath = "//span[text()=' Parent ']")
    private WebElement emgRelationParent;

    @FindBy(xpath = "//span[text()=' Sister/Brother ']")
    private WebElement emgRelationSisBro;

    @FindBy(xpath = "//span[text()=' Husband/Wife ']")
    private WebElement emgRelationHubWif;

    @FindBy(xpath = "//span[text()=' Cousin ']")
    private WebElement emgRelationCous;

    @FindBy(xpath = "//span[text()=' Friend ']")
    private WebElement emgRelationFriend;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;


    public ContractPage(WebDriver driver) {
        super(driver);
    }

    public ContractPage writeFirstName(String firstName) {
        commands.type(driver, inputFirstName, firstName);
        return this;
    }

    public ContractPage writeLastName(String lastName) {
        commands.type(driver, inputLastName, lastName);
        return this;
    }

    public ContractPage selectGender(String gender) {
        commands.clickElement(driver, genderDropdown);
        switch (gender.toLowerCase()) {
            case "male":
                commands.clickElement(driver, genderMaleDropdown);
                break;
            case "female":
                commands.clickElement(driver, genderFemaleDropdown);
                break;
            default:
                commands.clickElement(driver, genderNotSayDropdown);
                break;
        }
        return this;
    }

    public ContractPage selectBirthday(){
        commands.clickElementJS(driver, inputBirthday);
        commands.clickElement(driver, pickedBirthday);
        return this;
    }

    public ContractPage writeEmail(String email){
        commands.type(driver, inputEmail, email);
        return this;
    }

    public ContractPage writeTelephone(String telephone){
        commands.type(driver, inputTelephone, telephone);
        return this;
    }

    public ContractPage writeEmgName(String emgName) {
        commands.type(driver, inputEmgName, emgName);
        return this;
    }

    public ContractPage writeEmgLastName(String emgLastName) {
        commands.type(driver, inputEmgLastName, emgLastName);
        return this;
    }

    public ContractPage writeEmgTelephone(String emgTelephone){
        commands.type(driver, inputEmgPhoneNumber, emgTelephone);
        return this;
    }

    public ContractPage selectEmgContact(String relation) {
        commands.clickElement(driver, emgRelationDropdown);
        switch (relation.toLowerCase()) {
            case "parent":
                commands.clickElement(driver, emgRelationParent);
                break;
            case "sister/brother":
                commands.clickElement(driver, emgRelationSisBro);
                break;
            case "husband/wife":
                commands.clickElement(driver, emgRelationHubWif);
                break;
            case "cousin":
                commands.clickElement(driver, emgRelationCous);
                break;
            default:
                commands.clickElement(driver, emgRelationFriend);
                break;
        }
        return this;
    }

    public MembershipPage clickNextButton(){
        commands.clickElement(driver, nextButton);
        return new MembershipPage(driver);
    }

}
