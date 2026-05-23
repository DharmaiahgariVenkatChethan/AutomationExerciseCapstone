package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(xpath="//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath="//a[contains(text(),'Logged in as')]")
    WebElement loggedInText;
    
    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement logout;

    public void login(String mail, String pwd) {

        email.sendKeys(mail);

        password.sendKeys(pwd);

        loginButton.click();
    }
    public boolean verifyLogin() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        wait.until(ExpectedConditions.urlContains("automationexercise"));

        return driver.getPageSource().contains("Logged in as");
    }
    public void logout() {

        logout.click();
    }

    
}