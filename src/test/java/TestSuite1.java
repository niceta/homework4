import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestSuite1 extends BaseRunner {
    @Test
    public void test1() {
        driver.get("https://www.tinkoff.ru/");
        driver.findElement(By.xpath("//div[@id='x48761']/div[3]/div/div/div/div/div/div/div/div/div/div[6]/a/span")).click();
        driver.findElement(By.xpath("//input[@id='']")).click();
        driver.findElement(By.xpath("//input[@id='']")).clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("�������� ������");
        driver.findElement(By.xpath("//div[@id='search-and-pay-container']/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/div")).click();
        driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div/label")).click();
        driver.findElement(By.xpath("//input[@id='']")).clear();
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("5");
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div")).click();
        assertEquals(driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).getText(), "���� ������������");
        assertEquals(driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).getText(), "������� � 10 \u20BD");
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("�������� ��������� �����".equals(driver.getTitle())) break;
                Thread.sleep(1000);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
