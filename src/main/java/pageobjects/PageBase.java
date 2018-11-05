package pageobjects;

import io.appium.java_client.AppiumDriver;

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
