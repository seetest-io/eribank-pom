package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


/**
 * Class representing Login Page Object.
 */
public class LoginPage extends PageBase {

    @Override
    public boolean verify() {
        return (driver.findElements(ELEMENTS.USERNAME.getBy()).size() > 0);
    }

    /**
     * All Elements for this Page.
     */
    private enum ELEMENTS {

        USERNAME("//*[@id='usernameTextField']"),
        PASSWORD("//*[@id='passwordTextField']"),
        LOGIN_BUTTON("//*[@id='loginButton']");

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
     *
     * @param driver Driver instance.
     */
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Login to the Eri Bank page.
     *
     * @param userName - User Name.
     * @param password -Password.
     * @return EriBankMainPage. Returns the Eribank main page.
     */
    public EriBankMainPage login(String userName, String password) {
        LOGGER.info("Start - Login to application");
        driver.findElement(ELEMENTS.USERNAME.getBy()).sendKeys(userName);
        driver.findElement(ELEMENTS.PASSWORD.getBy()).sendKeys(password);
        driver.findElement(ELEMENTS.LOGIN_BUTTON.getBy()).click();
        LOGGER.info("END - Login to application");
        return new EriBankMainPage(driver);
    }

}
