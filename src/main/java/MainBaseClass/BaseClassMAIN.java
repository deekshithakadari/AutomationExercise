package MainBaseClass;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.chromium.HasCdp;

import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClassMAIN {

    protected WebDriver driver;

    // Log4j2 Logger
    protected static final Logger logger =
            LogManager.getLogger(BaseClassMAIN.class);


    // =========================================================
    // BROWSER SETUP
    // =========================================================

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp() {

        logger.info("========== Test Execution Started ==========");


        // -----------------------------------------------------
        // Read URL
        // -----------------------------------------------------

        logger.info("Reading URL from config.properties");

        String url =
                ConfigReader.getProperty("url");

        logger.info(
                "URL loaded successfully: {}",
                url);


        // -----------------------------------------------------
        // Read Browser
        // -----------------------------------------------------

        String browser =
                System.getProperty(
                        "browser",
                        ConfigReader.getProperty("browser"));

        logger.info(
                "Browser selected: {}",
                browser);


        // -----------------------------------------------------
        // Read Execution Environment
        // -----------------------------------------------------

        String executionEnvironment =
                System.getProperty(
                        "executionEnvironment",
                        ConfigReader.getProperty(
                                "execution_environment"));

        logger.info(
                "Execution environment selected: {}",
                executionEnvironment);


        // -----------------------------------------------------
        // Read Grid URL
        // -----------------------------------------------------

        String gridURL =
                ConfigReader.getProperty("gridURL");


        // -----------------------------------------------------
        // Validate Browser
        // -----------------------------------------------------

        if (browser == null
                || browser.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Browser is not specified in config.properties");
        }


        // -----------------------------------------------------
        // Validate Execution Environment
        // -----------------------------------------------------

        if (executionEnvironment == null
                || executionEnvironment.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "execution_environment is not specified in config.properties");
        }


        // =====================================================
        // LOCAL EXECUTION
        // =====================================================

        if (executionEnvironment.equalsIgnoreCase("local")) {

            logger.info(
                    "Running test in LOCAL environment");

            launchLocalBrowser(browser);
        }


        // =====================================================
        // SELENIUM GRID / REMOTE EXECUTION
        // =====================================================

        else if (executionEnvironment.equalsIgnoreCase("remote")) {

            logger.info(
                    "Running test on SELENIUM GRID");

            launchRemoteBrowser(
                    browser,
                    gridURL);
        }


        // =====================================================
        // DOCKER EXECUTION
        // =====================================================

        else if (executionEnvironment.equalsIgnoreCase("docker")) {

            logger.info(
                    "Running test in DOCKER environment");

            launchRemoteBrowser(
                    browser,
                    gridURL);
        }


        // =====================================================
        // INVALID ENVIRONMENT
        // =====================================================

        else {

            throw new IllegalArgumentException(
                    "Invalid execution_environment: "
                    + executionEnvironment);
        }


        // -----------------------------------------------------
        // Store WebDriver in TestNG Context
        // -----------------------------------------------------

        Reporter.getCurrentTestResult()
                .getTestContext()
                .setAttribute(
                        "WebDriver",
                        driver);


        // =====================================================
        // CHROMIUM DEVTOOLS NETWORK BLOCKING
        // =====================================================

        enableNetworkBlockingIfSupported();


        // -----------------------------------------------------
        // Implicit Wait
        // -----------------------------------------------------

        driver.manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(10));

        logger.info(
                "Implicit wait set to 10 seconds");


        // -----------------------------------------------------
        // Maximize Browser
        // -----------------------------------------------------

        driver.manage()
                .window()
                .maximize();

        logger.info(
                "Browser window maximized");


        // -----------------------------------------------------
        // Open URL
        // -----------------------------------------------------

        logger.info(
                "Navigating to URL: {}",
                url);

        driver.get(url);

        logger.info(
                "URL opened successfully");


        logger.info(
                "========== Browser Setup Completed ==========");
    }



    // =========================================================
    // LOCAL BROWSER
    // =========================================================

    private void launchLocalBrowser(
            String browser) {

        // -----------------------------------------------------
        // Chrome
        // -----------------------------------------------------

        if (browser.equalsIgnoreCase("chrome")) {

            logger.info(
                    "Launching Chrome browser");

            ChromeOptions options =
                    new ChromeOptions();

            driver =
                    new ChromeDriver(options);

            logger.info(
                    "Chrome browser launched successfully");
        }


        // -----------------------------------------------------
        // Edge
        // -----------------------------------------------------

        else if (browser.equalsIgnoreCase("edge")) {

            logger.info(
                    "Launching Edge browser");

            EdgeOptions options =
                    new EdgeOptions();

            driver =
                    new EdgeDriver(options);

            logger.info(
                    "Edge browser launched successfully");
        }


        // -----------------------------------------------------
        // Firefox
        // -----------------------------------------------------

        else if (browser.equalsIgnoreCase("firefox")) {

            logger.info(
                    "Launching Firefox browser");

            FirefoxOptions options =
                    new FirefoxOptions();

            driver =
                    new FirefoxDriver(options);

            logger.info(
                    "Firefox browser launched successfully");
        }


        // -----------------------------------------------------
        // Invalid Browser
        // -----------------------------------------------------

        else {

            throw new IllegalArgumentException(
                    "Invalid browser name in config.properties: "
                    + browser);
        }
    }



    // =========================================================
    // SELENIUM GRID / DOCKER REMOTE BROWSER
    // =========================================================

    private void launchRemoteBrowser(
            String browser,
            String gridURL) {

        if (gridURL == null
                || gridURL.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "gridURL is not specified in config.properties");
        }


        try {

            URL url =
                    new URL(gridURL);


            // -------------------------------------------------
            // Chrome
            // -------------------------------------------------

            if (browser.equalsIgnoreCase("chrome")) {

                logger.info(
                        "Launching Chrome browser through Selenium Grid/Docker");

                ChromeOptions options =
                        new ChromeOptions();

                RemoteWebDriver remoteDriver =
                        new RemoteWebDriver(
                                url,
                                options);

                driver =
                        new Augmenter().augment(remoteDriver);

                logger.info(
                        "Chrome browser started successfully on Selenium Grid/Docker");
            }


            // -------------------------------------------------
            // Edge
            // -------------------------------------------------

            else if (browser.equalsIgnoreCase("edge")) {

                logger.info(
                        "Launching Edge browser through Selenium Grid/Docker");

                EdgeOptions options =
                        new EdgeOptions();

                RemoteWebDriver remoteDriver =
                        new RemoteWebDriver(
                                url,
                                options);

                driver =
                        new Augmenter().augment(remoteDriver);

                logger.info(
                        "Edge browser started successfully on Selenium Grid/Docker");
            }


            // -------------------------------------------------
            // Firefox
            // -------------------------------------------------

            else if (browser.equalsIgnoreCase("firefox")) {

                logger.info(
                        "Launching Firefox browser through Selenium Grid/Docker");

                FirefoxOptions options =
                        new FirefoxOptions();

                driver =
                        new RemoteWebDriver(
                                url,
                                options);

                logger.info(
                        "Firefox browser started successfully on Selenium Grid/Docker");
            }


            // -------------------------------------------------
            // Invalid Browser
            // -------------------------------------------------

            else {

                throw new IllegalArgumentException(
                        "Invalid browser name in config.properties: "
                        + browser);
            }

        }

        catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Invalid Selenium Grid URL: "
                    + gridURL,
                    e);
        }
    }



    // =========================================================
    // NETWORK BLOCKING
    // =========================================================

    private void enableNetworkBlockingIfSupported() {

        if (driver instanceof HasCdp) {

            logger.info(
                    "CDP network blocking is supported for this browser");

            enableChromiumNetworkBlocking();
        }

        else {

            logger.info(
                    "CDP network blocking skipped - browser does not support Chromium CDP");
        }
    }



    // =========================================================
    // CHROME / EDGE NETWORK BLOCKING
    // =========================================================

    private void enableChromiumNetworkBlocking() {

        try {

            // -------------------------------------------------
            // Enable DevTools Network
            // -------------------------------------------------

            Map<String, Object> networkParams =
                    new HashMap<>();

            ((HasCdp) driver)
                    .executeCdpCommand(
                            "Network.enable",
                            networkParams);

            logger.info(
                    "Chrome/Edge DevTools Network enabled");


            // -------------------------------------------------
            // Block Advertisement Domains
            // -------------------------------------------------

            Map<String, Object> blockedUrls =
                    new HashMap<>();

            blockedUrls.put(
                    "urls",
                    Arrays.asList(

                            // Google advertising
                            "*://doubleclick.net/*",
                            "*://*.doubleclick.net/*",

                            "*://googlesyndication.com/*",
                            "*://*.googlesyndication.com/*",

                            "*://googleadservices.com/*",
                            "*://*.googleadservices.com/*",

                            "*://adservice.google.com/*",
                            "*://*.adservice.google.com/*",

                            // Google analytics / tracking
                            "*://google-analytics.com/*",
                            "*://*.google-analytics.com/*",

                            // Common advertising networks
                            "*://*.adroll.com/*",
                            "*://*.criteo.com/*",
                            "*://*.taboola.com/*",
                            "*://*.outbrain.com/*",
                            "*://*.pubmatic.com/*",
                            "*://*.rubiconproject.com/*",
                            "*://*.openx.net/*",
                            "*://*.amazon-adsystem.com/*"
                    )
            );


            ((HasCdp) driver)
                    .executeCdpCommand(
                            "Network.setBlockedURLs",
                            blockedUrls);

            logger.info(
                    "Common advertisement and tracking domains blocked");

        }

        catch (Exception e) {

            logger.warn(
                    "CDP network blocking could not be enabled. "
                    + "Test execution will continue.",
                    e);
        }
    }



    // =========================================================
    // CLOSE BROWSER
    // =========================================================

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        logger.info(
                "Starting browser teardown");


        if (driver != null) {

            driver.quit();

            logger.info(
                    "Browser closed successfully");
        }

        else {

            logger.warn(
                    "Driver was null. Browser was not closed.");
        }


        logger.info(
                "========== Test Execution Finished ==========");
    }



    // =========================================================
    // RANDOM DATA METHODS
    // =========================================================

    // Generate random alphabetic string

    public String randomString() {

        String value =
                RandomStringUtils.randomAlphabetic(5);

        logger.debug(
                "Generated random alphabetic string");

        return value;
    }


    // Generate random 10-digit number

    public String randomNumeric() {

        String value =
                RandomStringUtils.randomNumeric(10);

        logger.debug(
                "Generated random numeric value");

        return value;
    }


    // Generate random 6-digit PIN code

    public String randomPinCode() {

        String value =
                RandomStringUtils.randomNumeric(6);

        logger.debug(
                "Generated random numeric PIN code");

        return value;
    }


    // Generate random alphanumeric value

    public String randomAlphaNumeric() {

        String value =
                RandomStringUtils.randomAlphanumeric(10);

        logger.debug(
                "Generated random alphanumeric value");

        return value;
    }

}