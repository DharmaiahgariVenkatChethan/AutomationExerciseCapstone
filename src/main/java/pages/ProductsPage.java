package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id="search_product")
    WebElement searchBox;

    @FindBy(id="submit_search")
    WebElement searchButton;

    @FindBy(xpath="(//a[contains(text(),'Add to cart')])[1]")
    WebElement addCart;

    @FindBy(xpath="//u[text()='View Cart']")
    WebElement viewCart;
    
    @FindBy(xpath="//a[@href='#Women']")
    WebElement womenCategory;

    public void searchProduct() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(
        ExpectedConditions.visibilityOf(searchBox));

        searchBox.sendKeys("Tshirt");

        searchButton.click();
    }
    public void addProduct() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",addCart);

        js.executeScript("arguments[0].click();",addCart);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        

        wait.until(
        ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//u[text()='View Cart']")));

        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
    }
    public void selectCategory() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();",womenCategory);
    }

    
}