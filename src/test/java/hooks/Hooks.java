package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ScreenshotUtility;

public class Hooks extends BaseClass {

    @Before
    public void launchBrowser() {

        setup();
    }

    @After
    public void closeBrowser(
            Scenario scenario) {

        if(scenario.isFailed()) {

            ScreenshotUtility.captureScreenshot(
            scenario.getName());
        }

        tearDown();
    }
}