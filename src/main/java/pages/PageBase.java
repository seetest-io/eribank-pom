package pages;

import com.experitest.appium.SeeTestClient;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.impl.Log4jLoggerFactory;

/**
 * Base class for the page.
 */
public abstract class PageBase implements IPage {
    AppiumDriver driver;
    SeeTestClient client;
    Logger LOGGER = new Log4jLoggerFactory().getLogger(this.getClass().getName());

    PageBase(AppiumDriver driver) {
        LOGGER.info("Initializing {}", this.getClass().getName());
        this.driver = driver;
        client = new SeeTestClient(driver);
        if (!this.verify()) {
            throw new RuntimeException("Could not verify page " + this.getClass().getName());
        }
    }

}
