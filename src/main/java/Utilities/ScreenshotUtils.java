package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    // Log4j2 Logger
    private static final Logger logger =
            LogManager.getLogger(ScreenshotUtils.class);


    // Capture Screenshot
    public static String captureScreenshot(WebDriver driver, String testName) {

        // Check if driver is available
        if (driver == null) {

            logger.error("WebDriver is null. Screenshot cannot be captured.");

            return null;
        }


        // Create screenshots folder
        String screenshotPath = "./screenshots/";

        File screenshotFolder = new File(screenshotPath);

        if (!screenshotFolder.exists()) {

            screenshotFolder.mkdirs();

            logger.info("Screenshots folder created successfully");
        }


        // Take Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);


        // Create destination file
        File destination =
                new File(screenshotPath + testName + ".png");


        // Save Screenshot
        try {

            FileUtils.copyFile(source, destination);

            logger.info(
                    "Screenshot saved successfully: {}",
                    destination.getAbsolutePath()
            );

            return destination.getAbsolutePath();

        } catch (IOException e) {

            logger.error(
                    "Failed to save screenshot for test: {}",
                    testName,
                    e
            );

            return null;
        }
    }
}


