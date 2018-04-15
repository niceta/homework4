import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class TestTinkoffMobile extends BaseRunner {
    @Test
    void test() {
        driver.get("https://www.tinkoff.ru");
        driver.findElement(By.xpath("//*[contains(@class, 'FirstMenu')]//a[@href='/mobile-operator/']/span")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'SecondMenu')]//a[@href='/mobile-operator/tariffs/']")).click();

        WebElement accordion = driver.findElement(By.xpath("//*[@name='accordion']//h2"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", accordion);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textMoney = wait.until(d -> d.findElement(By.xpath("//*[contains(@class, 'TextMoney')]")).getText());
        //System.out.println(textMoney);
        sleep(500);

        driver.findElement(By.xpath("//*[@role='menuitem' and .//text()='0']")).click();
        driver.findElement(By.xpath("//*[@role='menuitem' and .//text()='0 ГБ']")).click();

        List<WebElement> togglers = driver.findElements(By.xpath("//*[contains(@class, 'toggler')]"));
        WebElement messengersToggle = togglers.get(1);
        WebElement networksToggle = togglers.get(2);

        WebElement musicLabel = driver.findElement(By.xpath("//*[text()='Музыка']"));
        js.executeScript("arguments[0].scrollIntoView(false)", musicLabel);

        messengersToggle.click();
        networksToggle.click();

        WebElement getSimButton = driver.findElement(By.xpath("(//button)[2]"));
        WebElement money = wait.until(d -> d.findElement(By.xpath("//*[contains(@class, 'TextMoney')]")));
        assertEquals(money.getText(), "0 \u20BD");
        assertEquals(getSimButton.isEnabled(), false);

        driver.navigate().refresh();

        accordion = driver.findElement(By.xpath("//*[@name='accordion']//h2"));
        js.executeScript("arguments[0].scrollIntoView(true)", accordion);
        money = wait.until(d -> d.findElement(By.xpath("//*[contains(@class, 'TextMoney')]")));
        assertEquals(money.getText(), textMoney);

        driver.findElement(By.xpath("(//*[@role='menuitem'])[13]")).click();
        List<WebElement> others = wait.until(d -> d.findElements(By.xpath("//span[@data-qa-file='TMobileCalculator']/div/*")));
        assertEquals(others.size(), 0);

        String unlimMoney = wait.until(d -> d.findElement(By.xpath("//*[contains(@class, 'TextMoney')]")).getText());
        driver.findElement(By.xpath("(//*[@role='menuitem'])[12]")).click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@name='mobileOperatorTariffCalculator']//span[@data-qa-node='span' and @data-qa-file='TMobileCalculator']//input[@type='checkbox']"));
        togglers = driver.findElements(By.xpath("//*[contains(@class, 'toggler')]"));
        for (int i = 1; i < togglers.size(); i++) {
            if (!checkBoxes.get(i - 1).isSelected()) {
                togglers.get(i).click();
            }
        }

        money = wait.until(d -> d.findElement(By.xpath("//*[contains(@class, 'TextMoney')]")));
        int unlim = Integer.parseInt(unlimMoney.replaceAll("\\D+", ""));
        int lim = Integer.parseInt(money.getText().replaceAll("\\D+", ""));
        assertEquals(lim < unlim, true);

        WebElement mobile = driver.findElement(By.xpath("//*[contains(@class, 'FirstMenu')]//a[@href='/mobile-operator/']"));
        js.executeScript("arguments[0].scrollIntoView(true)", mobile);
        mobile.click();

        driver.findElement(By.xpath("//*[@name='productBlock']//button")).click();
        WebElement calculator = driver.findElement(By.xpath("//*[@name='mobileOperatorTariffCalculator']"));
        assertEquals(calculator.isDisplayed(), true);
    }
}
