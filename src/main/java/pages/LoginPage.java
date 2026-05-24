package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

        email.clear();
        email.sendKeys(mail);

        password.clear();
        password.sendKeys(pwd);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                loginButton);
    }

    public boolean verifyLogin() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOf(
                        loggedInText));

        return loggedInText.isDisplayed();
    }

    public void logout() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,-500)");

        js.executeScript(
                "arguments[0].click();",
                logout);
    }
}