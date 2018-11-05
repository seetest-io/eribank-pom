package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
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
        findUserNameElement();
        findPasswordElement();
        findLoginButtonElement();
        this.initialized = true;
    }

    private WebElement usernameElement;
    private WebElement passwordElement;
    private WebElement loginButtonElement;

    /**
     * Finds the User Name Element.
     */
    private void findUserNameElement() {
        usernameElement = driver.findElement(By.xpath("//*[@id='usernameTextField']"));
    }

    /**
     * Finds the User Name Element.
     */
    private void findPasswordElement() {
        passwordElement = driver.findElement(By.xpath("//*[@id='passwordTextField']"));
    }

    /**
     * Finds the User Name Element.
     */
    private void findLoginButtonElement() {
        loginButtonElement = driver.findElement(By.xpath("//*[@id='loginButton']"));
    }

    /**
     * Login to the Eri Bank page.
     * @param userName - User Name.
     * @param password -Password.
     */
    public void login(String userName, String password) {
        usernameElement.sendKeys(userName);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

}
