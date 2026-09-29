package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReportManager;
import Utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    // Log4j2 Logger
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    // ExtentReports object
    private static ExtentReports extent = ExtentReportManager.getReportInstance();

    // ExtentTest object
    private static ExtentTest test;


    // Test Startedresult
    @Override
    public void onTestStart(ITestResult result) {

        //logger.info("========== TEST STARTED: {} ==========",result.getName());
    	
    	logger.info("TEST STARTED: {} | Thread ID: {}", result.getName(),Thread.currentThread().getId());

        // Create test in Extent Report
        test = extent.createTest(result.getName());
        test.info("Test execution started");
    }


    // Test Passed
    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("========== TEST PASSED: {} ==========", result.getName());
        test.pass("Test passed successfully");
    }


    // Test Failed
    @Override
    public void onTestFailure(ITestResult result) {

        logger.error( "========== TEST FAILED: {} ==========",result.getName());
        // Log failure reason
        logger.error("Failure reason:",result.getThrowable());

        // Add failure to Extent Report
        test.fail(result.getThrowable());

        // Get WebDriver from TestNG Test Context
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");

        // Check whether WebDriver is available
        if (driver == null) {

            logger.error("WebDriver is null. Screenshot cannot be captured.");
            test.warning("WebDriver is null. Screenshot cannot be captured.");
            return;
        }

        // Capture screenshot
        String screenshotPath = ScreenshotUtils.captureScreenshot(driver,result.getName());

        // Add screenshot to Extent Report
        if (screenshotPath != null) {

            logger.info("Failure screenshot saved at: {}",screenshotPath);

            try {

                test.addScreenCaptureFromPath(screenshotPath);

            } catch (Exception e) {

                logger.error("Unable to attach screenshot to Extent Report",e);
            }

        } else {

            logger.error("Failure screenshot could not be captured.");
            test.warning("Failure screenshot could not be captured.");
        }
    }


    // Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("========== TEST SKIPPED: {} ==========",result.getName());
        test.skip("Test was skipped");
    }


    // After all tests are finished
    @Override
    public void onFinish(org.testng.ITestContext context) {

        logger.info("========== TEST EXECUTION FINISHED ==========");

        // Write all information to HTML report
        extent.flush();

        logger.info("Extent Report generated successfully");
    }
}