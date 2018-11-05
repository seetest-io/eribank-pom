package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Page class representing Make Payments Page.
 */

public class MakePaymentsPage extends PageBase {

    private WebElement makePaymentButton;
    private WebElement phoneTextField;
    private WebElement nameTextField;
    private WebElement amountTextField;
    private WebElement countryTextField;
    private WebElement sendPaymentButton;
    private WebElement button1;

    /**
     * Constructor.
     */
    MakePaymentsPage(AppiumDriver driver1) {
        super(driver1);
        phoneTextField = driver.findElement(By.xpath("//*[@id='phoneTextField']"));
        nameTextField = driver.findElement(By.xpath("//*[@id='nameTextField']"));
        amountTextField = driver.findElement(By.xpath("//*[@id='amountTextField']"));
        countryTextField = driver.findElement(By.xpath("//*[@id='countryTextField']"));
        sendPaymentButton = driver.findElement(By.xpath("//*[@id='sendPaymentButton']"));
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
        phoneTextField.sendKeys(phoneText);
        nameTextField.sendKeys(nameText);
        amountTextField.sendKeys(amountText);
        countryTextField.sendKeys(countryText);
        sendPaymentButton.click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }
}