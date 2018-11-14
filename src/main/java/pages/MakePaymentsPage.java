package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


/**
 * Page class representing Make Payments Page.
 */

public class MakePaymentsPage extends PageBase {

    @Override
    public boolean verify() {
        return (driver.findElements(ELEMENTS.PHONE.getBy()).size() > 0);
    }

    /**
     * All Elements for this Page.
     */
    private enum ELEMENTS {

        PHONE("//*[@id='phoneTextField']"),
        NAME("//*[@id='nameTextField']"),
        AMOUNT("//*[@id='amountTextField']"),
        COUNTRY("//*[@id='countryTextField']"),
        SEND_PAYMENT_BUTTON("//*[@id='sendPaymentButton']"),
        YES("//*[@text='Yes']");

        private String location;

        /**
         * Constructor.
         *
         * @param location
         */
        ELEMENTS(String location) {
            this.location = location;
        }

        public By getBy() {
            return By.xpath(location);
        }

    }

    /**
     * Constructor.
     */
    MakePaymentsPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Makes the Payment.
     *
     * @param phoneText   Phone.
     * @param nameText    Name.
     * @param amountText  Amount.
     * @param countryText Country.
     */
    public void makePayment(String phoneText, String nameText, String amountText, String countryText) {
        LOGGER.info("Start - Fill Out Payment Form");
        driver.findElement(ELEMENTS.PHONE.getBy()).sendKeys(phoneText);
        driver.findElement(ELEMENTS.NAME.getBy()).sendKeys(nameText);
        driver.findElement(ELEMENTS.AMOUNT.getBy()).sendKeys(amountText);
        driver.findElement(ELEMENTS.COUNTRY.getBy()).sendKeys(countryText);
        driver.findElement(ELEMENTS.SEND_PAYMENT_BUTTON.getBy()).click();
        driver.findElement(ELEMENTS.YES.getBy()).click();
        LOGGER.info("END - Confirm Payment");
    }
}