package gitpractice.browser;

import org.openqa.selenium.WebDriver;

public class Browser {

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setBrowser(WebDriver driver) {
        WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static WebDriver getBrowser() {
        return WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static void unload() {
        WEB_DRIVER_THREAD_LOCAL.remove();
    }
}
