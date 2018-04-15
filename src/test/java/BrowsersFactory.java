import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;

public enum BrowsersFactory {
    chrome {
        public WebDriver create() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            return new ChromeDriver(options);
        }
    },
    firefox {
        public WebDriver create() {
            //FirefoxProfile profile = new FirefoxProfile();
            //FirefoxOptions options = new FirefoxOptions();
            //profile.setPreference("dom.webnotifications.enabled", false);
            //options.setProfile(profile);
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            return new FirefoxDriver(options);
        }
    };

    public WebDriver create() {
        return null;
    }
}
