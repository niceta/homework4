import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestKatalon extends BaseRunner {
    @Test
    public void test() {
        driver.get("https://www.tinkoff.ru/");
        driver.findElement(By.xpath("//div[@id='x48761']/div[3]/div/div/div/div/div/div/div[6]/a/span")).click();
        driver.findElement(By.xpath("//input[@id='']")).click();
        driver.findElement(By.xpath("//input[@id='']")).clear();
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("Тинькофф Мобайл");
        driver.findElement(By.xpath("//div[@id='search-and-pay-container']/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/div")).click();
        driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div/label")).click();
        driver.findElement(By.xpath("//input[@id='']")).clear();
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("5");
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div")).click();
        assertEquals(driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).getText(), "Поле обязательное");
        assertEquals(driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).getText(), "Минимум — 10 \u20BD");

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(d -> d.getTitle().equals("Оплатить мобильную связь"));
    }
}
