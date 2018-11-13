package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 *  Class representing Login Page Object.
 */
public class LoginPage extends PageBase {

    /**
     * All Elements for this Page.
     */
    private enum ELEMENTS {

        USERNAME ("//*[@id='usernameTextField']"),
        PASSWORD("//*[@id='passwordTextField']") ,
        LOGIN_BUTTON ("//*[@id='loginButton']");

        private String location;

        /**
         * Constructor.
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
     * @param driver1 Driver instance.
     */
    public LoginPage(AppiumDriver driver1) {
        super(driver1);
        this.initialized = true;
    }

    /**
     * Login to the Eri Bank page.
     * @param userName - User Name.
     * @param password -Password.
     * @return EriBankMainPage. Returns the Eribank main page.
     */
    public EriBankMainPage login(String userName, String password) {
        driver.findElement(ELEMENTS.USERNAME.getBy()).sendKeys(userName);
        driver.findElement(ELEMENTS.PASSWORD.getBy()).sendKeys(password);
        driver.findElement(ELEMENTS.LOGIN_BUTTON.getBy()).click();
        return new EriBankMainPage(driver);
    }

}
