package gitpractice.browser;

import gitpractice.factories.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Browser {


    public static WebDriver initBrowser(gitpractice.enums.Browser browser) {
        BrowserManager.setDriver(BrowserFactory.getBrowserDriver(browser));
        BrowserManager.getDriver().manage().window().maximize();
        BrowserManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return BrowserManager.getDriver();
    }

    public static void tearDownBrowser() {
        BrowserManager.getDriver().quit();
    }
}