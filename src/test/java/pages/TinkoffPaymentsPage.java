package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TinkoffPaymentsPage extends Page {
    @FindBy(xpath = "//input[@id='']")
    public WebElement searchLine;

    @FindBy(xpath = "//*[contains(text(), 'Тинькофф Мобайл')]")
    public WebElement tinkoffMobile;

    public TinkoffPaymentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void search(String request) {
        searchLine.click();
        searchLine.clear();
        searchLine.sendKeys(request);
        tinkoffMobile.click();
    }
}
