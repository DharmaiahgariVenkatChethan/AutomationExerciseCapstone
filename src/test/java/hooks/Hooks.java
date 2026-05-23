package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtility;

public class Hooks extends BaseClass {

    static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    static ExtentTest test;

    @Before
    public void launchBrowser(Scenario scenario) {

        test = extent.createTest(scenario.getName());

        setup();
    }

    @After
    public void closeBrowser(Scenario scenario) {

        if(scenario.isFailed()) {

            test.fail("Test Failed");

            ScreenshotUtility.captureScreenshot(
                    scenario.getName());
        }
        else {

            test.pass("Test Passed");
        }

        extent.flush();

        tearDown();
    }
}