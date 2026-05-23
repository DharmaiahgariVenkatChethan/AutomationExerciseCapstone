package pages;

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

    public void signup(String uname,
            String mail) {

        name.sendKeys(uname);

        email.sendKeys(mail);

        signupBtn.click();
    }

    public void clickSignupButton() {

        signupBtn.click();
    }
}