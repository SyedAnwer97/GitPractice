package gitpractice.utils;

import gitpractice.browser.BrowserManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * Utility class for capturing browser screenshots in Base64 format.
 *
 * <p>This class provides static methods to capture screenshots of the current
 * browser state, useful for embedding directly into reports and logs without
 * saving the image to disk.</p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>{@code
 * String screenshotInBase64 = ScreenshotUtility.captureScreenshotAsBase64();
 * }</pre>
 *
 * @author Syed Anwer
 * @version 1.0
 * @since 2025-04-27
 */
public final class ScreenshotUtility {

    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * <p>Throws an {@link UnsupportedOperationException} if an attempt is made
     * to instantiate this class.</p>
     */
    private ScreenshotUtility() {
        throw new UnsupportedOperationException("Cannot instantiate ScreenshotUtility: use static methods only.");
    }

    /**
     * Captures a screenshot of the current browser window and returns it as a Base64-encoded string.
     *
     * @return the screenshot in Base64 format
     * @throws NullPointerException if the WebDriver instance is not available
     */
    public static String captureScreenshotAsBase64() {
        WebDriver currentDriver = Objects.requireNonNull(
                BrowserManager.getDriver(),
                "WebDriver instance is not available. Cannot capture screenshot."
        );
        return ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BASE64);
    }
}
