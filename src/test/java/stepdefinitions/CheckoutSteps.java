package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CheckoutSteps extends BaseClass {

    CartPage cart;

    @When("user clicks proceed to checkout")
    public void user_clicks_proceed_to_checkout() {

        cart = new CartPage(driver);

        cart.clickCheckout();
    }

    @Then("checkout page should display")
    public void checkout_page_should_display() {

        Assert.assertTrue(
                driver.getPageSource()
                .contains("Address Details"));
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {

        cart = new CartPage(driver);

        cart.clickCheckout();
    }

    @When("user enters address details")
    public void user_enters_address_details() {

        Assert.assertTrue(
                driver.getPageSource()
                .contains("Checkout"));
    }

    @Then("address should save successfully")
    public void address_should_save_successfully() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Address Details"));
    }

    @Then("order review should display")
    public void order_review_should_display() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Place Order"));
    }

    @When("user completes checkout process")
    public void user_completes_checkout_process() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement commentBox =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//textarea[@name='message']")));

        commentBox.sendKeys("Order placed successfully");

        driver.findElement(
                By.xpath("//a[contains(text(),'Place Order')]"))
                .click();
    }

    @Then("order should place successfully")
    public void order_should_place_successfully() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains("payment"));

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("payment"));
    }
}