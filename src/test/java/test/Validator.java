package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Validator {
    private WebElement element;
    private List<WebElement> elements;

    public Validator(WebElement element) {
        this.element = element;
    }
    public Validator(List<WebElement> elements) {
        this.elements = elements;
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

    public void validateEnabled(boolean enabled) {assertEquals(enabled, element.isEnabled());}

    public void validateVisible(boolean visible) {assertEquals(visible, element.isDisplayed());}

    public void validateElementsNotVisible() {
         assertEquals(elements.size(), 0);
    }

    public void validateValueLessThan(String value) {
        int unlim = Integer.parseInt(value.replaceAll("\\D+", ""));
        int lim = Integer.parseInt(element.getText().replaceAll("\\D+", ""));
        assertEquals(lim < unlim, true);
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
