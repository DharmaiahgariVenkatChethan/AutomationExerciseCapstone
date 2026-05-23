package base;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;

public class BaseClass {

    public static WebDriver driver;

    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        driver = DriverFactory.initializeBrowser(browser);

        driver.get(ConfigReader.getProperty("url"));
    }

    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}