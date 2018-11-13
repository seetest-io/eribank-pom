package tests;

import com.experitest.appium.SeeTestCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.impl.Log4jLoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import org.slf4j.Logger;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.SeeTestProperties;

/**
 * Base class for all Eribank tests.
 */
public class TestBase {

    public static final String ENV_VAR_ACCESS_KEY = "SEETEST_IO_ACCESS_KEY";
    public static final boolean FULL_RESET = true;
    public static final boolean INSTRUMENT_APP = true;


    private DesiredCapabilities dc = new DesiredCapabilities();
    AppiumDriver driver = null;
    private String accessKey = null;
    Logger LOGGER = new Log4jLoggerFactory().getLogger(this.getClass().getName());

    protected Properties properties = new Properties();
    private String os;

    @Parameters("os")
    @BeforeClass
    public void setUp(@Optional("android") String os, ITestContext testContext) {
        LOGGER.info("Enter TestBase setUp");
        this.os = os;
        properties = SeeTestProperties.getSeeTestProperties();
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testContext.getCurrentXmlTest().getName());
        this.initDefaultDesiredCapabilities();
        driver = os.equals("android") ?
                new AndroidDriver(SeeTestProperties.SEETEST_IO_APPIUM_URL, dc) :
                new IOSDriver(SeeTestProperties.SEETEST_IO_APPIUM_URL, dc);
    }


    @AfterClass
    protected void tearDown() {
        driver.quit();
    }


    /**
     * Initialize default properties.
     */
    private void initDefaultDesiredCapabilities() {
        LOGGER.info("Setting up Desired Capabilities");
        accessKey = System.getenv(ENV_VAR_ACCESS_KEY);

        if (accessKey == null || accessKey.length() < 10) {
            LOGGER.error("Access key must be set in Environment variable {}", ENV_VAR_ACCESS_KEY);
            LOGGER.info("To get access get to to https://cloud.seetest.io or learn at https://docs.seetest.io/display/SEET/Execute+Tests+on+SeeTest+-+Obtaining+Access+Key", accessKey);
            throw new RuntimeException("Access key invalid : accessKey - " + accessKey);
        }

        this.setAppCapability(os);
        dc.setCapability(SeeTestCapabilityType.ACCESS_KEY, accessKey);

        dc.setCapability(MobileCapabilityType.FULL_RESET, FULL_RESET);
        dc.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, INSTRUMENT_APP);
        String query = String.format("@os='%s'", os);
        dc.setCapability(SeeTestCapabilityType.DEVICE_QUERY, query);

        LOGGER.info("Device Query = {}", query);
        LOGGER.info("Desired Capabilities setup complete");
    }


    /**
     * sets the application ("app") capability based on the OS and the property which was defined in the seetest.properties file
     *
     * @param os
     */
    private void setAppCapability(@Optional("android") String os) {
        String appName = os.equals("android") ?
                properties.getProperty(SeeTestProperties.Names.ANDROID_APP_NAME) :
                properties.getProperty(SeeTestProperties.Names.IOS_APP_NAME);

        appName = String.format("%s%s", "cloud:", appName);
        LOGGER.info("Setting up {} as app capability", appName);
        dc.setCapability(MobileCapabilityType.APP, appName);
    }

}
