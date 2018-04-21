package pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.Validator;

import static org.testng.Assert.assertEquals;

public class TinkoffMobilePage extends Page {
    @FindBy(xpath = "//*[contains(@class, 'row_combination')]//input[contains(@class, 'Input')]")
    public WebElement amount;

    @FindBy(xpath = "//*[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//button[contains(@class, 'pay')]")
    public WebElement payButton;

    @FindBy(xpath = "//*[contains(@class, 'row_phone')]//div[contains(@class, 'error-message')]")
    public WebElement phoneError;

    @FindBy(xpath = "//*[contains(@class, 'row_combination')]//div[contains(@class, 'error-message')]")
    public WebElement amountError;

    public TinkoffMobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void validatePhone(String number) {
        Validator phoneValidator = new Validator(phone);
        phoneValidator.input(number);

        String value = phone.getAttribute("value");
        Validator errorValidator = new Validator((phoneError));
        if (number.length() == 0) {
            errorValidator.validateText("Поле обязательное");
        }
        else if (number.length() < 10 ) {
            errorValidator.validateText("Поле неправильно заполнено");
        }
        else if (number.length() > 10) {
            assertEquals(value.length() <= 18, true);
        }

        phoneValidator.validatePhone(number);
        phoneValidator.validatePhoneMask();
    }

    public void validateAmount(String value) {
        Validator amountValidator = new Validator(amount);
        amountValidator.input(value);
        amountValidator.validateAmount(value);

        Validator errorValidator = new Validator(amountError);
        if (value.length() == 0) {
            errorValidator.validateText("Поле обязательное");
        }
        else if (value.length() > 256) {
            assertEquals(this.amount.getAttribute("value").length() < 257, true);
        }

        payButton.click();

        try {
            int val = Integer.parseInt(this.amount.getAttribute("value")
                    .replaceAll("\\D+", ""));
            if (val < 10) {
                errorValidator.validateText( "Минимум — 10 \u20BD");
            }
            else if (val > 15000) {
                errorValidator.validateText( "Максимум — 15 000 \u20BD");
            }
            /*else {
                assertEquals(driver.findElements(By.xpath("//*[contains(@class, 'row_phone')]//div[contains(@class, 'error-message')]")).size(), 0);
                assertEquals(driver.findElements(By.xpath("//*[contains(@class, 'row_combination')]//div[contains(@class, 'error-message')]")).size(), 0);
            }*/
        } catch (NumberFormatException e) {
            errorValidator.validateText( "Поле заполнено неверно");
        }
    }
}
