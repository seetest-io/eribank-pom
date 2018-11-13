package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Page class representing Make Payments Page.
 */

public class MakePaymentsPage extends PageBase {

    private By phoneBy = By.xpath("//*[@id='phoneTextField']");
    private By nameBy = By.xpath("//*[@id='nameTextField']");
    private By amountBy = By.xpath("//*[@id='amountTextField']");
    private By countryBy = By.xpath("//*[@id='countryTextField']");
    private By sendPaymentButtonBy = By.xpath("//*[@id='sendPaymentButton']");
    private By yesBy = By.xpath("//*[@text='Yes']");

    /**
     * Constructor.
     */
    MakePaymentsPage(AppiumDriver driver1) {
        super(driver1);
        this.initialized = true;
    }

    /**
     * Makes the Payment.
     * @param phoneText Phone.
     * @param nameText Name.
     * @param amountText Amount.
     * @param countryText Country.
     */
    public void makePayment(String phoneText, String nameText , String amountText, String countryText) {
        driver.findElement(phoneBy).sendKeys(phoneText);
        driver.findElement(nameBy).sendKeys(nameText);
        driver.findElement(amountBy).sendKeys(amountText);
        driver.findElement(countryBy).sendKeys(countryText);
        driver.findElement(sendPaymentButtonBy).click();
        driver.findElement(yesBy).click();
    }
}