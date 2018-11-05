package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.EriBankMainPage;
import pageobjects.LoginPage;



/**
 * Tests for EriBank.
 */
public class EriBankTests extends TestBase {

    private String testName = "Testing Payment - Changes to Payment Mechanism";

    @Test
    public void makePaymentTest() {
        LOGGER.info("Enter makePaymentTest");
        try{
            LOGGER.info("Attempting Login to Application");
            LoginPage loginPage = new LoginPage(driver);
            if (loginPage.isInitialized()) {
                loginPage.login("company", "company");
            }
            LOGGER.info("Login Complete");
            EriBankMainPage mainPage = new EriBankMainPage(driver);
            if (mainPage.isInitialized()) {
                LOGGER.info("Attempting Making Payment - Params = {Phone 123456 , name = Test , ...}");
                int beforeBalance = mainPage.getCurrentBalance();
                LOGGER.info("Before balance = " + beforeBalance);
                mainPage.makePayment("123456", "Test", "10", "US");
                LOGGER.info("Completed Payment - Params = {Phone 123456 , name = Test , ...}");
                int afterBalance = mainPage.getCurrentBalance();
                LOGGER.info("After balance = " + afterBalance);
            }
            LOGGER.info("MakePayment Test executed successfully");
        }
        catch(Exception e){
            LOGGER.error(e.getMessage());
            Assert.fail("Should not have failed.");
            LOGGER.info("Exit makePaymentTest with Exception ...");
        }
        LOGGER.info("Exit makePaymentTest successfully ...");
    }
}
