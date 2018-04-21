package app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import test.BrowsersFactory;

import java.util.concurrent.TimeUnit;

public class Application {
    public GooglePage googlePage;
    public GoogleResultPage googleResultPage;
    public TinkoffPage tinkoffPage;
    public TinkoffPaymentsPage paymentsPage;
    public TinkoffMobilePage mobilePage;

    private WebDriverWait wait;
    private WebDriver driver;

    public Application() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        googlePage = new GooglePage(driver);
        googleResultPage = new GoogleResultPage(driver);
        tinkoffPage = new TinkoffPage(driver);
        paymentsPage = new TinkoffPaymentsPage(driver);
        mobilePage = new TinkoffMobilePage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    public void switchWindow(String content) {
        for (String windows : driver.getWindowHandles()) {
            driver.switchTo().window(windows);
            if (driver.getTitle().contains(content)) {
                break;
            }
        }
    }

    private WebDriver getDriver() {
        String browserName;
        try {
            browserName = System.getProperty("browser");
            BrowsersFactory.valueOf(browserName);
        } catch (NullPointerException | IllegalArgumentException e) {
            //browserName = "firefox";
            browserName = "chrome";
            System.setProperty("browser", browserName);
        }
        return BrowsersFactory.valueOf(browserName).create();
    }
}
