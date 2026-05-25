package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[text()=' Signup / Login']")
    WebElement signupLogin;

    @FindBy(xpath="//a[text()=' Products']")
    WebElement products;

    @FindBy(xpath="//i[@class='fa fa-shopping-cart']")
    WebElement cart;

    @FindBy(xpath="//a[text()=' Contact us']")
    WebElement contactUs;

    public void clickSignupLogin() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                signupLogin);
    }

    public void clickProducts() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                products);
    }

    public void clickCart() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                cart);
    }

    public void clickContactUs() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                contactUs);
    }
}