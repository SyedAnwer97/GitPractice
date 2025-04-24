package gitpractice.browser;

import gitpractice.factories.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserManger {

    private static WebDriver driver = null;

    public static WebDriver initBrowser(String browser) {
        driver = BrowserFactory.BrowserDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void tearDownBrowser() {
        driver.quit();
    }
}