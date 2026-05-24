package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginSteps extends BaseClass {

    LoginPage login;

    @When("user enters valid login credentials")
    public void user_enters_valid_login_credentials() {

        login = new LoginPage(driver);

        login.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password"));
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {

        Assert.assertTrue(login.verifyLogin());
    }

    @When("user enters invalid login credentials")
    public void user_enters_invalid_login_credentials() {

        login = new LoginPage(driver);

        login.login(
                "cc512937@gmail.com",
                "test123");
    }

    @Then("login error message should display")
    public void login_error_message_should_display() {

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("incorrect"));
    }

    @When("user clicks logout button")
    public void user_clicks_logout_button() {

        login.logout();
    }

    @Then("login page should display")
    public void login_page_should_display() {

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("login"));
    }

    @Then("proper login validation message should display")
    public void proper_login_validation_message_should_display() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("incorrect"));
    }
}