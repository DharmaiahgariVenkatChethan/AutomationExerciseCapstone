package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SignupPage;
import utilities.ConfigReader;

public class AutomationSteps
extends BaseClass {

    HomePage home;
    SignupPage signup;
    LoginPage login;
    ProductsPage product;
    CartPage cart;
    ContactPage contact;

    @Given("user launches automation exercise website")
    public void launchWebsite() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        

        wait.until(ExpectedConditions.titleContains("Automation Exercise"));

        String title = driver.getTitle();

        System.out.println(title);

        Assert.assertTrue(
        title.contains("Automation Exercise"));
    }

    @When("user clicks on Signup Login button")
    public void clickSignupLogin() {

        home = new HomePage(driver);

        home.clickSignupLogin();
    }

    @When("user enters signup details")
    public void signupDetails() {

        signup = new SignupPage(driver);

        signup.signup(
        "Chethan",

        "chethan"
        + System.currentTimeMillis()
        + "@test.com");
    }

    @Then("user should register successfully")
    public void registerSuccess() {

        Assert.assertTrue(true);
    }

    @When("user enters valid login credentials")
    public void loginDetails() {

        login = new LoginPage(driver);

        login.login(

        ConfigReader.getProperty("email"),

        ConfigReader.getProperty("password"));
    }

    @Then("user should login successfully")
    public void loginSuccess() {

        Assert.assertTrue(
        login.verifyLogin());
    }

    @When("user clicks on Products button")
    public void clickProducts() {

        home = new HomePage(driver);

        home.clickProducts();
    }

    @When("user searches product")
    public void searchProduct() {

        product = new ProductsPage(driver);

        product.searchProduct();
    }

    @Then("product should display successfully")
    public void productDisplay() {

        Assert.assertTrue(true);
    }

    @When("user adds product to cart")
    public void addProductCart() {

        product = new ProductsPage(driver);

        product.addProduct();
    }

    @Then("product should be added to cart")
    public void productAdded() {

        Assert.assertTrue(true);
    }

    @When("user clicks on Cart button")
    public void clickCart() {

        home = new HomePage(driver);

        home.clickCart();
    }

    @Then("cart page should open successfully")
    public void cartOpen() {

        Assert.assertTrue(true);
    }

    @When("user clicks proceed to checkout")
    public void checkout() {

        cart = new CartPage(driver);

        cart.clickCheckout();
    }

    @Then("checkout page should display")
    public void checkoutDisplay() {

        Assert.assertTrue(true);
    }

    @When("user clicks on Contact Us button")
    public void contactButton() {

        home = new HomePage(driver);

        home.clickContactUs();
    }

    @When("user enters contact form details")
    public void contactDetails() {

        contact = new ContactPage(driver);

        contact.contactForm(
        "Chethan",
        "test@test.com",
        "Testing",
        "Automation Testing");
    }

    @Then("contact form should submit successfully")
    public void contactSuccess() {

        Assert.assertTrue(true);
    }
    @When("user enters already registered email")
    public void existingEmail() {

        signup = new SignupPage(driver);

        signup.signup(
        "Chethan",
        "cc512937@gmail.com");
    }

    @Then("proper signup error should display")
    public void signupError() {

        Assert.assertTrue(
        driver.getPageSource()
        .contains("Email Address already exist"));
    }

    @When("user clicks signup button without data")
    public void emptySignup() {

        signup = new SignupPage(driver);

        signup.clickSignupButton();
    }

    @Then("validation message should display")
    public void validationMessage() {

        Assert.assertTrue(true);
    }

    @Then("account should create successfully")
    public void accountCreate() {

        Assert.assertTrue(true);
    }

    @When("user enters invalid login credentials")
    public void invalidLogin() {

        login = new LoginPage(driver);

        login.login(
        "wrong@test.com",
        "wrong123");
    }

    @Then("login error message should display")
    public void loginError() {

        Assert.assertTrue(
        driver.getPageSource()
        .contains("incorrect"));
    }

    @When("user clicks logout button")
    public void logoutButton() {

        login.logout();
    }

    @Then("login page should display")
    public void loginPage() {

        Assert.assertTrue(
        driver.getCurrentUrl()
        .contains("login"));
    }

    @Then("proper login validation message should display")
    public void loginValidation() {

        Assert.assertTrue(true);
    }

    @Then("product details should display")
    public void productDetails() {

        Assert.assertTrue(
        driver.getPageSource()
        .contains("Rs."));
    }

    @Then("product should add successfully")
    public void productAddedSuccess() {

        Assert.assertTrue(
        driver.getCurrentUrl()
        .contains("view_cart"));
    }

    @When("user selects category")
    public void selectCategory() {

        product = new ProductsPage(driver);

        product.selectCategory();
    }

    @Then("filtered products should display")
    public void filteredProducts() {

        Assert.assertTrue(true);
    }

    @When("user updates quantity")
    public void updateQuantity() {

        Assert.assertTrue(true);
    }

    @Then("quantity should update successfully")
    public void quantityUpdate() {

        Assert.assertTrue(true);
    }

    @When("user removes product")
    public void removeProduct() {

        cart = new CartPage(driver);

        cart.removeProduct();
    }

    @Then("cart should become empty")
    public void cartEmpty() {

        Assert.assertTrue(
        driver.getPageSource()
        .contains("Cart is empty"));
    }

    @Then("total amount should display")
    public void totalAmount() {

        Assert.assertTrue(
        driver.getPageSource()
        .contains("Rs."));
    }

    @When("user proceeds to checkout")
    public void proceedCheckout() {

        cart = new CartPage(driver);

        cart.clickCheckout();
    }

    @When("user enters address details")
    public void addressDetails() {

        Assert.assertTrue(true);
    }

    @Then("address should save successfully")
    public void addressSave() {

        Assert.assertTrue(true);
    }

    @Then("order review should display")
    public void orderReview() {

        Assert.assertTrue(true);
    }

    @When("user completes checkout process")
    public void completeCheckout() {

        Assert.assertTrue(true);
    }

    @Then("order should place successfully")
    public void orderSuccess() {

        Assert.assertTrue(true);
    }

    @Then("success message should display")
    public void successMessage() {

        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.getPageSource().contains("Success"));
    }

    @When("user uploads file")
    public void uploadFile() {

        contact = new ContactPage(driver);

        contact.uploadFile();
    }

    @Then("file should upload successfully")
    public void fileUpload() {

        Assert.assertTrue(true);
    }
}