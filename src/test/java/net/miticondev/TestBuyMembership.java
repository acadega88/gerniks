package net.miticondev;

import net.miticondev.pages.*;
import net.miticondev.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;


public class TestBuyMembership extends BaseTest {

    WebDriver driver;
    String URL = ConfigProperties.getURL();
    int randomI = new Random().nextInt(100);
    String firstName = "Dwight";
    String lastName = "Schrute";
    String gender = "Prefer not to say";
    String birthday = "01.07.2023";
    String email = "dwightKSchrute" + randomI + "@dunderMifflin.com";
    String telephone = "78897966" + randomI; // NOYB in Ascii :)
    String emgName = "Michael";
    String emgLastName = "Scott";
    String emgTelephone = "55589745" + randomI;
    String emgRelation = "Friend";
    String accountOwner = "Dwight Schrute";
    String bankName = "Scranton Bank";
    String iban = "8548548544";
    String bic = "78897966";
    SoftAssert softAssert = new SoftAssert();
    String expectedHeading = "WELCOME TO FITPLUS!";
    String expectedParagraph = "You have been successfully registered as FitPlus member!";
    String expectedText = "Please, check your email.";


    @BeforeClass
    public void setup() {
        driver = getDriver(URL);
    }

    @Test
    public void testingBuyMembership() {
        StartTrainingPage startTrainingPage = new StartTrainingPage(driver);
        ContractPage contractPage = startTrainingPage.buyMembership();

        contractPage.writeFirstName(firstName)
                .writeLastName(lastName)
                .selectGender(gender)
                .selectBirthday()
                .writeEmail(email)
                .writeTelephone(telephone)
                .writeEmgName(emgName)
                .writeEmgLastName(emgLastName)
                .writeEmgTelephone(emgTelephone)
                .selectEmgContact(emgRelation);

        MembershipPage membershipPage = contractPage.clickNextButton();
        membershipPage.selectStartDate();

        PaymentPage paymentPage = membershipPage.clickNextButton();
        paymentPage.writeAccountOwner(accountOwner)
                .writeBankName(bankName)
                .writeIban(iban)
                .writeBic(bic)
                .payment()
                .selectPaymentMethod();

        StartPage startPage = paymentPage.clickNextButton();
        String contractInfoText = startPage.getContactInformation();

        softAssert.assertTrue(contractInfoText.contains(firstName));
        softAssert.assertTrue(contractInfoText.contains(lastName));
        softAssert.assertTrue(contractInfoText.contains(gender));
        softAssert.assertTrue(contractInfoText.contains(birthday));
        softAssert.assertTrue(contractInfoText.contains(email));
        softAssert.assertTrue(contractInfoText.contains(telephone));
        softAssert.assertTrue(contractInfoText.contains(emgName));
        softAssert.assertTrue(contractInfoText.contains(emgLastName));
        softAssert.assertTrue(contractInfoText.contains(emgTelephone));
        softAssert.assertTrue(contractInfoText.contains(emgRelation));

        SubmitPage submitPage = startPage.clickStartTraining();
        String actualSubmitContent = submitPage.getSubmitContent();

        Assert.assertTrue(actualSubmitContent.contains(expectedHeading));
        Assert.assertTrue(actualSubmitContent.contains(expectedParagraph));
        Assert.assertTrue(actualSubmitContent.contains(expectedText));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
