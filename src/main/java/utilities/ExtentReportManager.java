package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        String reportPath = System.getProperty("user.dir")
                + "/test-output/ExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(reportPath);

        reporter.config().setReportName("Automation Exercise Report");
        reporter.config().setDocumentTitle("Capstone Report");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Venkat Chethan");

        return extent;
    }
}