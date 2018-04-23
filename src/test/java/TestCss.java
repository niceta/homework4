import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCss extends BaseRunner {
    @Test
    public void test() {
        driver.get("https://www.google.ru");

        driver.findElement(By.cssSelector("#lst-ib")).click();
        driver.findElement(By.cssSelector("#lst-ib")).clear();
        driver.findElement(By.cssSelector("#lst-ib")).sendKeys("tinkoff");
        driver.findElement(By.cssSelector("#lst-ib")).sendKeys(Keys.ENTER);

        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector("[href=\"https://www.tinkoff.ru/\"]")).click();

        switchWindow(parentHandle);

        driver.findElement(By.cssSelector("[class*=SecondMenu] [href=\"/payments/\"]")).click();
        driver.findElement(By.cssSelector("[id=search-and-pay-container] [type=\"text\"]")).click();
        driver.findElement(By.cssSelector("[id=search-and-pay-container] [type=\"text\"]")).clear();
        driver.findElement(By.cssSelector("[id=search-and-pay-container] [type=\"text\"]")).sendKeys("Тинькофф Мобайл");
        driver.findElement(By.cssSelector("[class*=\"SearchSuggest__entry\"]:first-child > div")).click();

        driver.findElement(By.cssSelector("[class*=\"row_combination\"] input[class*=\"Input\"]")).click();
        driver.findElement(By.cssSelector("[class*=\"row_combination\"] input[class*=\"Input\"]")).clear();
        driver.findElement(By.cssSelector("[class*=\"row_combination\"] input[class*=\"Input\"]")).sendKeys("5");

        driver.findElement(By.cssSelector("button[class*=\"pay\"]")).click();

        assertEquals(driver.findElement(By.cssSelector("[class*=\"row_phone\"] [class*=\"error-message\"]")).getText(), "Поле обязательное");
        assertEquals(driver.findElement(By.cssSelector("[class*=\"row_combination\"] [class*=\"error-message\"]")).getText(), "Минимум — 10 \u20BD");

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(d -> d.getTitle().equals("Оплатить мобильную связь"));
    }
}
