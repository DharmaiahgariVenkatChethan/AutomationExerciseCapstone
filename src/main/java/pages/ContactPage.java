package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver) {

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

        name.sendKeys(uname);

        email.sendKeys(mail);

        subject.sendKeys(sub);

        message.sendKeys(msg);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        

        js.executeScript("arguments[0].scrollIntoView(true);", submit);
        

        js.executeScript("arguments[0].click();", submit);
        
        
    }
    public void uploadFile() {

        upload.sendKeys(
        "C:\\Users\\Chethan\\Downloads\\test.txt");
    }
}