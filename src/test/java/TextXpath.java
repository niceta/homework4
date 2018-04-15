import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextXpath extends BaseRunner {
    @Test
    public void test() {
        driver.get("https://www.google.ru");
        driver.findElement(By.xpath("//*[@id='lst-ib']")).click();
        driver.findElement(By.xpath("//*[@id='lst-ib']")).clear();
        driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("tinkoff");
        driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(Keys.ENTER);

        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@href='https://www.tinkoff.ru/']")).click();

        switchWindow(parentHandle);

        driver.findElement(By.xpath("//div[contains(@class, 'SecondMenu')]//a[@href='/payments/']")).click();
        driver.findElement(By.xpath("//input[@id='']")).click();
        driver.findElement(By.xpath("//input[@id='']")).clear();
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("Тинькофф Мобайл");
        driver.findElement(By.xpath("//*[contains(text(), 'Тинькофф Мобайл')]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'row_combination')]//input[contains(@class, 'Input')]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'row_combination')]//input[contains(@class, 'Input')]")).clear();
        driver.findElement(By.xpath("//*[contains(@class, 'row_combination')]//input[contains(@class, 'Input')]")).sendKeys("5");

        driver.findElement(By.xpath("//button[contains(@class, 'pay')]")).click();

        assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'row_phone')]//div[contains(@class, 'error-message')]")).getText(), "Поле обязательное");
        assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'row_combination')]//div[contains(@class, 'error-message')]")).getText(), "Минимум — 10 \u20BD");

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(d -> d.getTitle().equals("Оплатить мобильную связь"));
    }
}
