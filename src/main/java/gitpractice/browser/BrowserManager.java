package gitpractice.browser;

import org.openqa.selenium.WebDriver;

/**
 * Manages WebDriver instances for thread-safe browser operations.
 *
 * <p>This utility class provides methods to set, retrieve, and unload
 * WebDriver instances associated with the current thread. It ensures
 * that WebDriver instances are isolated between different threads,
 * promoting safe parallel test execution.</p>
 *
 * <p><b>Usage:</b> Set the driver when a new browser session starts,
 * get the driver when needed during a test, and unload it at the end
 * of the session to avoid memory leaks.</p>
 *
 * <p><b>Example:</b></p>
 * <pre>{@code
 * BrowserManager.setDriver(new ChromeDriver());
 * WebDriver driver = BrowserManager.getDriver();
 * BrowserManager.unloadDriver();
 * }</pre>
 *
 * <p>This class cannot be instantiated, as it is designed to be used solely
 * with static methods.</p>
 *
 * @author Syed Anwer
 * @version 1.0
 * @since 2025-04-27
 */
public final class BrowserManager {

    /**
     * ThreadLocal variable to hold WebDriver instances per thread.
     * This ensures that each thread has its own independent WebDriver instance.
     */
    private static final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(() -> null);

    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * <p>This constructor throws an {@link UnsupportedOperationException}
     * if called, as this class is intended to be used in a static way only.</p>
     */
    private BrowserManager() {
        throw new UnsupportedOperationException("Cannot instantiate BrowserManager: use static methods only.");
    }

    /**
     * Sets the WebDriver instance for the current thread.
     *
     * <p>This method associates the provided WebDriver instance with the current thread,
     * ensuring that each thread has its own WebDriver for safe parallel execution.</p>
     *
     * @param driver the WebDriver instance to be associated with the current thread
     */
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    /**
     * Retrieves the WebDriver instance associated with the current thread.
     *
     * <p>If no WebDriver has been set for the current thread, this method returns {@code null}.</p>
     *
     * @return the WebDriver instance for the current thread, or {@code null} if none set
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Removes the WebDriver instance associated with the current thread
     * to prevent memory leaks.
     *
     * <p>This method is important for cleanup after the test has finished,
     * especially when tests are executed in parallel.</p>
     */
    public static void unloadDriver() {
        driverThreadLocal.remove();
    }

    /**
     * Checks if a WebDriver instance is set for the current thread.
     *
     * <p>This method helps in checking whether the current thread has a
     * WebDriver instance set before performing any actions with the driver.</p>
     *
     * @return {@code true} if a driver is set, {@code false} otherwise
     */
    public static boolean hasDriver() {
        return driverThreadLocal.get() != null;
    }
}
