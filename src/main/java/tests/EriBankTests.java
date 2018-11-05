package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.EriBankMainPage;
import pageobjects.LoginPage;
import pageobjects.MakePaymentsPage;


/**
 * Tests for EriBank.
 */
public class EriBankTests extends TestBase {

    private String testName = "Testing Payment - Changes to Payment Mechanism";

    @Test
    public void makePaymentTest() {
        LOGGER.info("Enter makePaymentTest");
        EriBankMainPage mainPage;
        try{
            LOGGER.info("Attempting Login to Application");
            LoginPage loginPage = new LoginPage(driver);
            if (loginPage.isInitialized()) {
                mainPage = loginPage.login("company", "company");
                if (mainPage.isInitialized()) {
                    LOGGER.info("Attempting Making Payment - Params = {Phone 123456 , name = Test , ...}");
                    int beforeBalance = mainPage.getCurrentBalance();
                    LOGGER.info("Before balance = " + beforeBalance);
                    int amount = 10;
                    MakePaymentsPage makePaymentsPage = mainPage.getMakePaymentsPage();
                    makePaymentsPage.makePayment("123456", "Test", Integer.toString(amount), "US");
                    LOGGER.info("Completed Payment - Params = {Phone 123456 , name = Test , ...}");
                    int afterBalance = mainPage.getCurrentBalance();
                    LOGGER.info("After balance = " + afterBalance);
                    Assert.assertEquals(afterBalance, beforeBalance - amount);
                }
                LOGGER.info("Login Complete");
                LOGGER.info("MakePayment Test executed successfully");
            }
        }
        catch(Exception e){
            LOGGER.error(e.getMessage());
            Assert.fail("Should not have failed.");
            LOGGER.info("Exit makePaymentTest with Exception ...");
        }
        LOGGER.info("Exit makePaymentTest successfully ...");
    }
}
