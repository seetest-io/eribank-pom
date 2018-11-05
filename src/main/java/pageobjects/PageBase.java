package pageobjects;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;

/**
 * Base class for the page.
 */
public abstract class PageBase {
    AppiumDriver driver;
    boolean initialized = false;

    /**
     * Empty Constructor.
     *
     */
    PageBase(AppiumDriver driver1) {
        driver = driver1;
    }


    /**
     * Return if this page is initialized.
     * @return initialized
     */
    public boolean isInitialized() {
        return initialized;
    }

}
