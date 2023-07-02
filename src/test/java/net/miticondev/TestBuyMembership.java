package net.miticondev;

import net.miticondev.pages.*;
import net.miticondev.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;


public class TestBuyMembership extends BaseTest {

    WebDriver driver;
    String URL = ConfigProperties.getURL();
    int randomI = new Random().nextInt(100);
    String firstName = "Dwight " + randomI;
    String lastName = "Schrute " + randomI;
    String gender = "NOYB";
    String email = "dwightKSchrute" + randomI + "@dunderMifflin.com";
    String telephone = "78897966" + randomI; // NOYB in Ascii :)
    String emgName = "Michael " + randomI;
    String emgLastName = "Scott " + randomI;
    String emgTelephone = "55589745" + randomI;
    String emgRelation = "Boss and BFF";
    String accountOwner = "Dwight Schrute " + randomI;
    String bankName = "Scranton Bank";
    String iban = "8548548544";
    String bic = "78897966";


    @BeforeClass
    public void setup(){
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



    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
