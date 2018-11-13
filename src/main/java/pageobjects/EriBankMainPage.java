package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing the Main Menu Page for Eribank Applications.
 */
public class EriBankMainPage extends PageBase {

    private By makePaymentButton = By.xpath("//*[@id='makePaymentButton']");
    private By balanceElement = By.xpath("//*[contains(text(),\"$\")]");
    private MakePaymentsPage makePaymentPage;

    /**
     * Constructor.
     * @param driver1 Driver instance.
     */
    EriBankMainPage(AppiumDriver driver1) {
        super(driver1);
        initialized = true;
    }

    /**
     * Gets the Make Payments Page.
     * @return makePaymentPage Return Make Payments Page.
     */
    public MakePaymentsPage getMakePaymentsPage() {
        driver.findElement(makePaymentButton).click();
        makePaymentPage = new MakePaymentsPage(this.driver);
        return makePaymentPage;
    }

    /**
     * Gets current Balance.
     * @return Current balance.
     */
    public int getCurrentBalance() throws NoSuchElementException {
        String balanceField = driver.findElement(balanceElement).getText();
        Pattern pattern = Pattern.compile("\\d{1,10}");
        Matcher matcher = pattern.matcher(balanceField);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            throw new NoSuchElementException("Current Balance Not Found");
        }
    }
}
