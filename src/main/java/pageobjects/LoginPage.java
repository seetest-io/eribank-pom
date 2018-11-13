package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 *  Class representing Login Page Object.
 */
public class LoginPage extends PageBase {

    /**
     * Constructor.
     * @param driver1 Driver instance.
     */
    public LoginPage(AppiumDriver driver1) {
        super(driver1);
        this.initialized = true;
    }

    private By usernameBy = By.xpath("//*[@id='usernameTextField']");
    private By passwordBy = By.xpath("//*[@id='passwordTextField']");
    private By loginButtonBy = By.xpath("//*[@id='loginButton']");

    /**
     * Login to the Eri Bank page.
     * @param userName - User Name.
     * @param password -Password.
     * @return EriBankMainPage. Returns the Eribank main page.
     */
    public EriBankMainPage login(String userName, String password) {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
        return new EriBankMainPage(driver);
    }

}
