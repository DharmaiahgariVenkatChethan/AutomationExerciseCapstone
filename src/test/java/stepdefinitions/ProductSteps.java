package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductsPage;

public class ProductSteps extends BaseClass {

    HomePage home;
    ProductsPage product;

    @When("user clicks on Products button")
    public void user_clicks_on_products_button() {

        home = new HomePage(driver);

        home.clickProducts();
    }

    @When("user searches product")
    public void user_searches_product() {

        product = new ProductsPage(driver);

        product.searchProduct();
    }

    @Then("product should display successfully")
    public void product_should_display_successfully() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Tshirt"));
    }

    @Then("product details should display")
    public void product_details_should_display() {

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Rs."));
    }

    @When("user adds product to cart")
    public void user_adds_product_to_cart() {

        product = new ProductsPage(driver);

        product.addProduct();
    }

    @Then("product should add successfully")
    public void product_should_add_successfully() {

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("view_cart"));
    }

    @When("user selects category")
    public void user_selects_category() {

        product = new ProductsPage(driver);

        product.selectCategory();
    }

    @Then("filtered products should display")
    public void filtered_products_should_display() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Women"));
    }
}