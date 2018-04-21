package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TinkoffPage extends Page {
    @FindBy(xpath = "//div[contains(@class, 'SecondMenu')]//a[@href='/payments/']")
    public WebElement payments;

    public TinkoffPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }
}
