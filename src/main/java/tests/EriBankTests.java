package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EriBankMainPage;
import pages.LoginPage;
import pages.MakePaymentsPage;


/**
 * Tests for EriBank.
 */


/**
 * TODO :
 */
public class EriBankTests extends TestBase {

    private String testName = "Testing Payment - Changes to Payment Mechanism";
    EriBankMainPage mainPage;
    LoginPage loginPage;

    @Test
    public void makePaymentTest() {
        final String PHONE_NUMBER = "123456";
        final String COUNTRY = "US";
        final String NAME = "Test";

        LOGGER.info("Enter makePaymentTest");
        LOGGER.info("Attempting Login to Application");

        loginPage = new LoginPage(driver);

        mainPage = loginPage.login("company", "company");
        LOGGER.info("Login Complete");
        LOGGER.info("Attempting Making Payment - Params = {Phone 123456 , name = Test , ...}");
        int beforeBalance = mainPage.getCurrentBalance();
        LOGGER.info("Before balance = " + beforeBalance);
        int amount = 10;
        MakePaymentsPage makePaymentsPage = mainPage.navigateToMakePaymentPage();
        makePaymentsPage.makePayment(PHONE_NUMBER, NAME, Integer.toString(amount), COUNTRY);
        LOGGER.info("Completed Payment - Params = {Phone 123456 , name = Test , ...}");
        int afterBalance = mainPage.getCurrentBalance();
        LOGGER.info("After balance = " + afterBalance);
        Assert.assertEquals(afterBalance, beforeBalance - amount);

        LOGGER.info("MakePayment Test executed successfully");
        LOGGER.info("Exit makePaymentTest successfully ...");
    }
}
