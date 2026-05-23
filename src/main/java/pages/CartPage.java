package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//i[@class='fa fa-shopping-cart']")
    WebElement checkout;

    public void clickCheckout() {

        checkout.click();
    }
    @FindBy(xpath="//a[@class='cart_quantity_delete']")
    WebElement deleteProduct;
    
    public void removeProduct() {

        deleteProduct.click();
    }
}