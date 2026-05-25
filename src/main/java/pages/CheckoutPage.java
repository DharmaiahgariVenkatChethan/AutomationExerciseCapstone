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

    By nameOnCard =
            By.name("name_on_card");

    By cardNumber =
            By.name("card_number");

    By cvc =
            By.name("cvc");

    By expiryMonth =
            By.name("expiry_month");

    By expiryYear =
            By.name("expiry_year");

    By payButton =
            By.id("submit");

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

    public void enterPaymentDetails() {

        driver.findElement(nameOnCard)
                .sendKeys("Chethan");

        driver.findElement(cardNumber)
                .sendKeys("1234567890123456");

        driver.findElement(cvc)
                .sendKeys("123");

        driver.findElement(expiryMonth)
                .sendKeys("12");

        driver.findElement(expiryYear)
                .sendKeys("2028");
    }

    public void clickPayAndConfirmOrder() {

        WebElement payBtn =
                driver.findElement(payButton);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,500)");

        js.executeScript(
                "arguments[0].click();",
                payBtn);
    }
}