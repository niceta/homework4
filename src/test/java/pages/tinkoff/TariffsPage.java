package pages.tinkoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TariffsPage extends Page {
    @FindBy(xpath="//*[@name='accordion']//h2")
    public WebElement accordion;

    @FindBy(xpath = "//*[contains(@class, 'TextMoney')]")
    public WebElement price;

    @FindBy(xpath = "//*[@role='menuitem' and .//text()='0']")
    public WebElement zeroMinutes;

    @FindBy(xpath = "//*[@role='menuitem' and .//text()='0 ГБ']")
    public WebElement zeroGb;

    @FindBy(xpath = "(//*[contains(@class, 'toggler')])[2]")
    public WebElement messToggle;

    @FindBy(xpath = "(//*[contains(@class, 'toggler')])[3]")
    public WebElement networkToggle;

    @FindBy(xpath = "(//*[contains(@class, 'toggler')])[4]")
    public WebElement musicToggle;

    @FindBy(xpath = "(//*[contains(@class, 'toggler')])[5]")
    public WebElement videoToggle;

    @FindBy(xpath = "(//button)[2]")
    public WebElement getSimButton;

    @FindBy(xpath = "(//*[@role='menuitem'])[13]")
    public WebElement unlimInternet;

    @FindBy(xpath = "//span[@data-qa-file='TMobileCalculator']/div/*")
    public List<WebElement> limitedElements;

    @FindBy(xpath = "(//*[@role='menuitem'])[12]")
    public WebElement fifteen;

    @FindBy(xpath = "//*[contains(@class, 'FirstMenu')]//a[@href='/mobile-operator/']")
    public WebElement mobileButton;

    public TariffsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        sleep(1000);
        return wait.until(d -> price.getText());
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
