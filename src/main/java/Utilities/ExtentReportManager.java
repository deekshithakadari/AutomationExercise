package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    // Create and configure ExtentReports
    public static ExtentReports getReportInstance() {

        if (extent == null) {

            // Location of HTML report
            String reportPath = "./reports/ExtentReport.html";

            // Create Spark Reporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            // Create ExtentReports
            extent = new ExtentReports();

            // Attach Spark Reporter
            extent.attachReporter(sparkReporter);

            // Add system information
            extent.setSystemInfo("OS", "Windows");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "Automation Tester");
            extent.setSystemInfo("Application", "Automation Exercise");
        }

        return extent;
    }
}