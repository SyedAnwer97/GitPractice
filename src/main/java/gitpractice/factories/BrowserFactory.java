package gitpractice.factories;

import gitpractice.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Factory class responsible for providing WebDriver instances based on the specified browser type.
 * This class uses an {@link EnumMap} to map the {@link Browser} enum values to their respective WebDriver suppliers,
 * ensuring that all WebDriver instances are created with the appropriate browser configurations, including private/incognito modes
 * for supported browsers.
 * <p>
 * The class cannot be instantiated, and it exposes static methods to get WebDriver instances for supported browsers.
 * The browser types are specified using the {@link Browser} enum.
 * </p>
 *
 * @author Syed Anwer
 * @version 1.0
 * @since 2025-04-27
 */
public final class BrowserFactory {

    private static final Map<Browser, Supplier<WebDriver>> browserDriverSuppliers = new EnumMap<>(Browser.class);

    static {
        browserDriverSuppliers.put(Browser.CHROME, createChromeDriverSupplier());
        browserDriverSuppliers.put(Browser.FIREFOX, createFirefoxDriverSupplier());
        browserDriverSuppliers.put(Browser.EDGE, createEdgeDriverSupplier());
    }

    /**
     * Private constructor to prevent instantiation of the BrowserFactory class.
     * This class should only be used via its static methods.
     */
    private BrowserFactory() {
        throw new UnsupportedOperationException("Cannot instantiate utility class BrowserFactory.");
    }

    /**
     * Creates and returns a Supplier for creating a ChromeDriver with Incognito mode.
     * This Supplier is mapped to the {@link Browser} enum value representing the Chrome browser.
     *
     * @return a Supplier that creates a ChromeDriver with Incognito mode
     */
    private static Supplier<WebDriver> createChromeDriverSupplier() {
        return () -> {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            return new ChromeDriver(options);
        };
    }

    /**
     * Creates and returns a Supplier for creating a FirefoxDriver with Private mode.
     * This Supplier is mapped to the {@link Browser} enum value representing the Firefox browser.
     *
     * @return a Supplier that creates a FirefoxDriver with Private Browsing mode
     */
    private static Supplier<WebDriver> createFirefoxDriverSupplier() {
        return () -> {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            return new FirefoxDriver(options);
        };
    }

    /**
     * Creates and returns a Supplier for creating an EdgeDriver with InPrivate mode.
     * This Supplier is mapped to the {@link Browser} enum value representing the Edge browser.
     *
     * @return a Supplier that creates an EdgeDriver with InPrivate mode
     */
    private static Supplier<WebDriver> createEdgeDriverSupplier() {
        return () -> {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--inprivate");
            return new EdgeDriver(options);
        };
    }

    /**
     * Returns the appropriate WebDriver instance for the specified browser.
     * The browser type is provided via the {@link Browser} enum.
     *
     * @param browser the browser type specified by the {@link Browser} enum
     * @return the WebDriver instance for the specified browser
     * @throws IllegalArgumentException if the browser is null or if the browser type is unsupported
     */
    public static WebDriver getBrowserDriver(Browser browser) {
        if (Objects.isNull(browser)) {
            throw new IllegalArgumentException("Browser type cannot be null.");
        }

        Supplier<WebDriver> driverSupplier = browserDriverSuppliers.get(browser);

        if (Objects.isNull(driverSupplier)) {
            throw new IllegalArgumentException("Unsupported browser: " + browser.name());
        }

        return driverSupplier.get();
    }
}
