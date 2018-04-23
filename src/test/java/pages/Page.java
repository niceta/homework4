package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String handle;
    protected String url;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.navigate().to(url);
        handle = driver.getWindowHandle();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
}
