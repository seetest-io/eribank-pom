package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing the Main Menu Page for Eribank.
 */
public class EriBankMainPage extends PageBase {

    private WebElement makePaymentButton;
    private WebElement balanceElement;
    private PageBase makePaymentPage;

    /**
     * Constructor.
     * @param driver1 Driver instance.
     */
    public EriBankMainPage(AppiumDriver driver1) {
        super(driver1);
        makePaymentButton = driver.findElement(By.xpath("//*[@id='makePaymentButton']"));
        initialized = true;
    }


    /**
     * Make Payment Implementation.
     * @param phoneText Phone Number.
     * @param nameText Name.
     * @param amountText Amount.
     * @param countryText Country.
     */
    public void makePayment(String phoneText, String nameText , String amountText, String countryText) {
        makePaymentButton.click();
        makePaymentPage = new MakePaymentsPage(this.driver);
        ((MakePaymentsPage)makePaymentPage).makePayment(phoneText, nameText , amountText, countryText);
    }

    /**
     * Gets current Balance.
     * @return Current balance.
     */
    public int getCurrentBalance() throws NoSuchElementException {
        String balanceField = driver.findElement(By.xpath("//*[contains(text(),\"$\")]")).getText();
        Pattern pattern = Pattern.compile("\\d{1,10}");
        Matcher matcher = pattern.matcher(balanceField);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            throw new NoSuchElementException("Current Balance Not Found");
        }
    }

}
