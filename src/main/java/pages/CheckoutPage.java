package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    public void placeOrder() {

        WebElement placeOrderBtn =
                driver.findElement(
                        By.xpath("//a[contains(text(),'Place Order')]"));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,500)");

        js.executeScript(
                "arguments[0].click();",
                placeOrderBtn);
    }
}