package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing the Main Menu Page for Eribank Applications.
 */
public class EriBankMainPage extends PageBase {

    @Override
    public boolean verify() {
        return (driver.findElements(ELEMENTS.MAKE_PAYMENT_BUTTON.getBy()).size() > 0);
    }

    /**
     * All Elements for this Page.
     */
    private enum ELEMENTS {
        MAKE_PAYMENT_BUTTON ("//*[@id='makePaymentButton']"),
        BALANCE("//*[contains(text(),'$')]");

        private String location;
        /**
         * Constructor.
         * @param location - Location String.
         */
        ELEMENTS(String location) {
            this.location = location;
        }

        /**
         * Gets the By Object.
         * @return by object.
         */
        public By getBy() {
            return By.xpath(location);
        }
    }

    /**
     * Constructor.
     * @param driver Driver instance.
     */
    EriBankMainPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Gets the Make Payments Page.
     * @return makePaymentPage Return Make Payments Page.
     */
    public MakePaymentsPage navigateToMakePaymentPage() {
        driver.findElement(ELEMENTS.MAKE_PAYMENT_BUTTON.getBy()).click();
        return new MakePaymentsPage(this.driver);
    }

    /**
     * Gets current Balance.
     * @return Current balance.
     */
    public int getCurrentBalance() throws NoSuchElementException {
        String balanceField = driver.findElement(ELEMENTS.BALANCE.getBy()).getText();
        Pattern pattern = Pattern.compile("\\d{1,10}");
        Matcher matcher = pattern.matcher(balanceField);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            throw new NoSuchElementException("Current Balance Not Found");
        }
    }
}
