package gitpractice.report;

import com.aventstack.extentreports.ExtentTest;

/**
 * A utility class for managing {@link ExtentTest} instances in a thread-safe manner.
 *
 * <p>This class ensures that each thread gets its own {@link ExtentTest} instance
 * for safe parallel execution during test reporting.</p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>{@code
 * ExtentTestManager.setExtentTest(extentReports.createTest("Login Test"));
 * ExtentTest test = ExtentTestManager.getExtentTest();
 * if (ExtentTestManager.hasExtentTest()) {
 *     test.pass("Step passed");
 * }
 * ExtentTestManager.unloadExtentTest();
 * }</pre>
 *
 * <p>The {@link ExtentTest} instance must be unloaded after test execution to prevent memory leaks.</p>
 *
 * @version 1.2
 * @since 2025-04-27
 * @author Syed Anwer
 */
public final class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ExtentTestManager() {
        throw new UnsupportedOperationException("Cannot instantiate ExtentTestManager: use static methods only.");
    }

    /**
     * Associates an {@link ExtentTest} instance with the current thread.
     *
     * @param extentTest the {@link ExtentTest} instance to associate
     */
    public static void setExtentTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }

    /**
     * Retrieves the {@link ExtentTest} instance associated with the current thread.
     *
     * @return the {@link ExtentTest} instance, or {@code null} if none is set
     */
    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    /**
     * Checks whether an {@link ExtentTest} instance is associated with the current thread.
     *
     * @return {@code true} if a test is present, {@code false} otherwise
     */
    public static boolean hasExtentTest() {
        return extentTestThreadLocal.get() != null;
    }

    /**
     * Removes the {@link ExtentTest} instance associated with the current thread,
     * to prevent memory leaks and stale references.
     */
    public static void unloadExtentTest() {
        extentTestThreadLocal.remove();
    }
}
