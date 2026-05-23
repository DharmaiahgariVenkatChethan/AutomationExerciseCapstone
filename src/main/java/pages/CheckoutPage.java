package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By placeOrder = By.xpath("//a[contains(text(),'Place Order')]");

    public void placeOrder() {

        driver.findElement(placeOrder).click();
    }
}