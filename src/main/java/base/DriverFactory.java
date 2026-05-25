package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public static WebDriver initializeBrowser(String browser) {

        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            
            options.addArguments("--headless=new");

            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);

        }

        else if(browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            
            options.addArguments("--headless=new");

            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();

        return driver;
    }
}