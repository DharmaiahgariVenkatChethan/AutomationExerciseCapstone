package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@data-qa='signup-name']")
    WebElement name;

    @FindBy(xpath="//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath="//button[@data-qa='signup-button']")
    WebElement signupBtn;
    
    @FindBy(xpath="//b[text()='Account Created!']")
    WebElement successSignupMsg;
    
    @FindBy(xpath="//button[text()='Create Account']")
    WebElement createAccountBtn;
    
    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="last_name")
    WebElement lastName;
    
    @FindBy(id="password")
    WebElement password;
    
    @FindBy(id="address1")
    WebElement address;
    
    @FindBy(id="state")
    WebElement state;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="zipcode")
    WebElement zipcode;

    @FindBy(id="mobile_number")
    WebElement mobile;

    public void signup(String uname,
            String mail) {

        name.clear();
        name.sendKeys(uname);

        email.clear();
        email.sendKeys(mail);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                signupBtn);
    }

    public void clickSignupButton() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                signupBtn);
    }
    
    public void enterAccountDetails() {

//        titleMr.click();
    	

        password.sendKeys("Test@123");

//        day.sendKeys("10");
//
//        month.sendKeys("May");
//
//        year.sendKeys("2000");
//
//        newsletter.click();
//
//        offers.click();

        firstName.sendKeys("Chethan");

        lastName.sendKeys("D");

//        company.sendKeys("Wipro");

        address.sendKeys("Bangalore");

//        country.sendKeys("India");

        state.sendKeys("Karnataka");

        city.sendKeys("Bangalore");

        zipcode.sendKeys("560001");

        mobile.sendKeys("9876543210");

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,500)");

        
    }

    
    
    
    public boolean isSuccessSignupMsgDisplayed() {
//    	Thread.sleep(2000);
//    	return successSignupMsg.isDisplayed();
    	 return driver.getPageSource()
    	            .contains("Account Created!");
    }
    
    public void clickCreateAccountBtn() {
    	createAccountBtn.click();
    }
    
}