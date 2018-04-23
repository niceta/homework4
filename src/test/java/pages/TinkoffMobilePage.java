package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TinkoffMobilePage extends Page {
    @FindBy(xpath = "//*[contains(@class, 'SecondMenu')]//a[@href='/mobile-operator/tariffs/']")
    public WebElement tariffsButton;

    @FindBy(xpath = "//*[@name='productBlock']//button")
    public WebElement simCardButton;

    @FindBy(xpath = "//*[@id='form-application']")
    public WebElement calculator;

    public TinkoffMobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
