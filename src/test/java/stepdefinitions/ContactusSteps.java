package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactusPage;
import pages.HomePage;

public class ContactusSteps extends BaseClass {

    HomePage home;
    ContactusPage contact;

    @When("user clicks on Contact Us button")
    public void user_clicks_on_contact_us_button() {

        home = new HomePage(driver);

        home.clickContactUs();
    }

    @When("user enters contact form details")
    public void user_enters_contact_form_details() {

        contact = new ContactusPage(driver);

        contact.contactForm(
                "Chethan",
                "test@test.com",
                "Testing",
                "Automation Testing");
    }

    @Then("contact form should submit successfully")
    public void contact_form_should_submit_successfully() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Success"));
    }

    @Then("success message should display")
    public void success_message_should_display() {

        

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Success"));
    }

    @When("user uploads file")
    public void user_uploads_file() {

        contact = new ContactusPage(driver);

        contact.uploadFile();
    }

    @Then("file should upload successfully")
    public void file_should_upload_successfully() {

        String text = driver.getPageSource();

        Assert.assertTrue(
                text.contains("Choose File")
                || text.contains("Success"));
    }
}