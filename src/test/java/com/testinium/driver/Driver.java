package com.testinium.driver;

import com.thoughtworks.gauge.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    public static WebDriver driver;
    public static AppiumDriver<MobileElement> appiumDriver;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected boolean localAndroid = true;

    @BeforeScenario
    public void setUp(ExecutionContext executionContext) throws MalformedURLException {

        logger.info("\n" +
                " _____    _   __      _ \n" +
                "(  _  ) /' )/' _`\\  /' )\n" +
                "| (_) |(_, || ( ) |(_, |\n" +
                "|  _  |  | || | | |  | |\n" +
                "| | | |  | || (_) |  | |\n" +
                "(_) (_)  (_)`\\___/'  (_)\n" +
                "                        \n" +
                "                        \n");
            logger.info("-------------------------------------------------------");
            logger.info("-                 A101 WEB OTOMASYON                  -");
            logger.info("-------------------------------------------------------");
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-blink-features");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
    }

    @AfterScenario
    public void tearDown(){
        if(driver != null) {
            driver.close();
            driver.quit();
        }

        if(appiumDriver != null){
            appiumDriver.closeApp();
            appiumDriver.quit();
        }
    }
}
