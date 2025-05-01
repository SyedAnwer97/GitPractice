package gitpractice.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import gitpractice.enums.LogLevel;
import gitpractice.utils.ScreenshotUtility;

import java.util.EnumMap;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A utility class for logging test results and exceptions to ExtentReports.
 * This class handles different log levels (PASS, FAIL, SKIP, INFO) and also supports
 * logging failures with screenshots and exceptions.
 * <p>
 * It provides methods to log messages and exceptions at various log levels, with optional
 * screenshots for failures and detailed exception logging.
 * </p>
 *
 * <h2>Usage Example:</h2>
 * <pre>
 * ExtentLogger.log(Logs.PASS, "Test Passed");
 * ExtentLogger.logThrowable(Logs.FAIL, new Exception("Test failed"));
 * </pre>
 *
 * @author Syed Anwer
 * @version 1.1
 * @since 2025-04-27
 */
public final class ExtentLogger {

    private static final EnumMap<LogLevel, Consumer<Object>> logConsumers = new EnumMap<>(LogLevel.class);

    private static final Consumer<Object> PASS_LOG = logText -> ExtentTestManager.getExtentTest()
            .log(Status.PASS, (String) logText);
    private static final Consumer<Object> FAIL_LOG = logText -> ExtentTestManager.getExtentTest()
            .log(Status.FAIL, (String) logText);
    private static final Consumer<Object> SKIP_LOG = logText -> ExtentTestManager.getExtentTest()
            .log(Status.SKIP, (String) logText);
    private static final Consumer<Object> INFO_LOG = logText -> ExtentTestManager.getExtentTest()
            .log(Status.INFO, (String) logText);

    private static final Consumer<Object> EXCEPTION_LOG = throwable -> ExtentTestManager.getExtentTest()
            .log(Status.FAIL, (Throwable) throwable);
    private static final Consumer<Object> FAIL_WITH_SCREENSHOT_LOG = logText -> ExtentTestManager.getExtentTest()
            .log(Status.FAIL, (String) logText, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility
                    .captureScreenshotAsBase64()).build());


    static {
        logConsumers.put(LogLevel.PASS, PASS_LOG);
        logConsumers.put(LogLevel.FAIL, FAIL_LOG);
        logConsumers.put(LogLevel.SKIP, SKIP_LOG);
        logConsumers.put(LogLevel.INFO, INFO_LOG);
        logConsumers.put(LogLevel.FAIL_WITH_SCREENSHOT, FAIL_LOG.andThen(FAIL_WITH_SCREENSHOT_LOG));
        logConsumers.put(LogLevel.EXCEPTION_LOG, EXCEPTION_LOG);
    }

    /**
     * Logs a message at the specified log level.
     *
     * @param logLevel   the log level (PASS, FAIL, SKIP, INFO, etc.)
     * @param logMessage the message to be logged
     */
    public static void log(LogLevel logLevel, String logMessage) {
        Consumer<Object> logConsumer = logConsumers.get(logLevel);
        if (Objects.isNull(logConsumer)) throw new IllegalArgumentException("Invalid log level: " + logLevel);
        logConsumer.accept(logMessage);
    }

    /**
     * Logs an exception at the specified log level.
     *
     * @param logLevel  the log level (usually FAIL for exceptions)
     * @param exception the exception to be logged
     */
    public static void logException(LogLevel logLevel, Throwable exception) {
        Consumer<Object> exceptionConsumer = logConsumers.get(logLevel);
        if (Objects.isNull(exceptionConsumer))
            throw new IllegalArgumentException("Invalid log level for exception: " + logLevel);
        exceptionConsumer.accept(exception);
    }
}
