import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseRunner {
    public WebDriver driver;
    public String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        baseUrl = "https://www.tinkoff.ru/";
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    private WebDriver getDriver() {
        String browserName;
        try {
            browserName = System.getProperty("browser");
            BrowsersFactory.valueOf(browserName);
        } catch (NullPointerException | IllegalArgumentException e) {
            browserName = "firefox";
            System.setProperty("browser", browserName);
        }
        return BrowsersFactory.valueOf(browserName).create();
    }
}
