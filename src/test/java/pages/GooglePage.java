package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends Page {
    @FindBy(xpath = "//*[@id='lst-ib']")
    public WebElement searchLine;

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://www.google.ru");
        handle = driver.getWindowHandle();
    }

    public void search(String request) {
        searchLine.click();
        searchLine.clear();
        searchLine.sendKeys(request);
        searchLine.sendKeys(Keys.ENTER);
    }
}
