package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;

public class Validator {
    private WebElement element;

    public Validator(WebElement mainElement) {
        this.element = mainElement;
    }

    public void input(String text) {
       element.click();
       element.clear();
       element.sendKeys(text);
       element.sendKeys(Keys.ENTER);
    }

    public void validateText(String expected) {
        assertEquals(expected, element.getText());
    }

    public void validatePhone(String number) {
        String numberWithoutSymbols = "7" + number.replaceAll("\\D+", "");
        if (numberWithoutSymbols.length() > 11)
            numberWithoutSymbols = numberWithoutSymbols.substring(0, 11);

        String reg = "[+)( -]";
        String valueWithoutSymbols = element.getAttribute("value").replaceAll(reg, "");

        assertEquals(valueWithoutSymbols,  numberWithoutSymbols);
    }

    public void validateAmount(String value) {
        String reg = "[^0-9)(*/+-]";
        String valueWithoutSymbols = value.replaceAll(reg, "");
        String amountWithoutSymbols = element.getAttribute("value");
        assertEquals(valueWithoutSymbols, amountWithoutSymbols);
    }

    public void validatePhoneMask() {
        String value = element.getAttribute("value");
        assertEquals(value.charAt(0) == '+' &&
                value.charAt(2) == ' ' &&
                value.charAt(3) == '(', true);

        if (value.length() > 5) {
            assertEquals(value.charAt(7) == ')' && value.charAt(8) == ' ', true);
        }
        if (value.length() > 10) {
            assertEquals(value.charAt(12) == '-', true);
        }
        if (value.length() > 12) {
            assertEquals(value.charAt(15) == '-', true);
        }
    }
}
