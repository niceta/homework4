package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage extends Page{
    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url) {
        driver.findElement(By.xpath("//*[@href='" + url + "']")).click();
    }
}
