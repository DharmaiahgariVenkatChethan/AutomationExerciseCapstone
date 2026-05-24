package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactusPage {

    WebDriver driver;

    public ContactusPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name="name")
    WebElement name;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="subject")
    WebElement subject;

    @FindBy(id="message")
    WebElement message;

    @FindBy(name="submit")
    WebElement submit;

    @FindBy(name="upload_file")
    WebElement upload;

    public void contactForm(
            String uname,
            String mail,
            String sub,
            String msg) {

        name.clear();
        name.sendKeys(uname);

        email.clear();
        email.sendKeys(mail);

        subject.clear();
        subject.sendKeys(sub);

        message.clear();
        message.sendKeys(msg);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,500)");

        js.executeScript(
                "arguments[0].click();",
                submit);

        try {

            driver.switchTo().alert().accept();

        } catch (Exception e) {

            System.out.println(
                    "No alert present");
        }
    }

    public void uploadFile() {

        upload.sendKeys(
        "C:\\Users\\Chethan\\Downloads\\test.txt");

        System.out.println(
                "File uploaded successfully");
    }
}