package pages.tinkoff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

public class TinkoffPage extends Page {
    @FindBy(xpath = "//div[contains(@class, 'SecondMenu')]//a[@href='/payments/']")
    public WebElement payments;

    @FindBy(xpath = "//*[contains(@class, 'FirstMenu')]//a[@href='/mobile-operator/']")
    public WebElement mobileButton;

    public TinkoffPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
        PageFactory.initElements(driver, this);
    }
}
