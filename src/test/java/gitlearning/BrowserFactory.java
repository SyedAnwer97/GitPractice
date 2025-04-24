package gitlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserFactory {

    private static final Map<String, Supplier<WebDriver>> BROWSER_MAP = new HashMap<>();

    private static final Supplier<WebDriver> CHROME = ChromeDriver::new;
    private static final Supplier<WebDriver> FIREFOX = FirefoxDriver::new;

    static {
        BROWSER_MAP.put("chrome", CHROME);
        BROWSER_MAP.put("firefox", FIREFOX);
    }

    public static WebDriver BrowserDriver(String browser) {
        return BROWSER_MAP.get(browser).get();
    }
}