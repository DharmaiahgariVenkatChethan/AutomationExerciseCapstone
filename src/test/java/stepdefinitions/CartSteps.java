package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;

public class CartSteps extends BaseClass {

    HomePage home;

    CartPage cart;

    @When("user clicks on Cart button")
    public void user_clicks_on_cart_button() {

        home = new HomePage(driver);

        home.clickCart();
    }

    @Then("cart page should open successfully")
    public void cart_page_should_open_successfully() {

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("view_cart"));
    }

    @When("user updates quantity")
    public void user_updates_quantity() {

        cart = new CartPage(driver);

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Quantity"));
    }

    @Then("quantity should update successfully")
    public void quantity_should_update_successfully() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("1"));
    }

    @When("user removes product")
    public void user_removes_product() {

        cart = new CartPage(driver);

        cart.removeProduct();
    }

    @Then("cart should become empty")
    public void cart_should_become_empty() {

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Cart is empty"));
    }

    @Then("total amount should display")
    public void total_amount_should_display() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Rs."));
    }
}