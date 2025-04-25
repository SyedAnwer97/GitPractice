package gitpractice.browser;

import gitpractice.factories.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserManger {
    

    public static WebDriver initBrowser(String browser) {
        Browser.setBrowser(BrowserFactory.BrowserDriver(browser));
        Browser.getBrowser().manage().window().maximize();
        Browser.getBrowser().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return Browser.getBrowser();
    }

    public static void tearDownBrowser() {
        Browser.getBrowser().quit();
    }
}