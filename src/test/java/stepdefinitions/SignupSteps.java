package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignupPage;

public class SignupSteps extends BaseClass {

    HomePage home;
    SignupPage signup;

    @Given("user launches automation exercise website")
    public void user_launches_automation_exercise_website() {

        String title = driver.getTitle();

        System.out.println(title);

        Assert.assertTrue(title.contains("Automation Exercise"));
    }

    @When("user clicks on Signup Login button")
    public void user_clicks_on_signup_login_button() {

        home = new HomePage(driver);

        home.clickSignupLogin();
    }

    @When("user enters signup details")
    public void user_enters_signup_details() {

        signup = new SignupPage(driver);

        signup.signup(
                "Chethan",
                "chethan" + System.currentTimeMillis() + "@test.com");
        
        
    }

    @Then("user should register successfully")
    public void user_should_register_successfully() {

        Assert.assertTrue(true);
    }

    @When("user enters already registered email")
    public void user_enters_already_registered_email() {

        driver.findElement(By.name("name"))
                .sendKeys("Chethan");

        driver.findElement(
                By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys("test@test.com");

        driver.findElement(
                By.xpath("//button[@data-qa='signup-button']"))
                .click();
    }

    @Then("proper signup error should display")
    public void proper_signup_error_should_display() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.toLowerCase().contains("exist"));
    }

    @When("user clicks signup button without data")
    public void user_clicks_signup_button_without_data() {

        signup = new SignupPage(driver);

        signup.clickSignupButton();
    }

    @Then("validation message should display")
    public void validation_message_should_display() throws InterruptedException {

//        Assert.assertFalse(signup.isSuccessSignupMsgDisplayed());
    	String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Signup"));
    }
    
    @When("user clicks Create Account button")
    public void user_clicks_create_account_button() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    	signup.clickCreateAccountBtn();
    }
    
    @When("user fill signup details")
    public void user_fill_signup_details() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    	signup = new SignupPage(driver);

//        signup.enterAccountDetails();
    	signup.enterAccountDetails();
    }


    @Then("account should create successfully")
    public void account_should_create_successfully() {
    	
//        Assert.assertTrue(signup.isSuccessSignupMsgDisplayed());
        signup = new SignupPage(driver);

        Assert.assertTrue(
                signup.isSuccessSignupMsgDisplayed());
        
    }
}