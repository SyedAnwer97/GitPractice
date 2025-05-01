package gitpractice.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Objects;

/**
 * A utility class for managing Extent Reports and generating HTML reports for test execution results.
 *
 * <p>This class provides static methods to initialize the report, create individual tests within the report,
 * and flush the report to save it to the disk. The class is designed to ensure thread-safe initialization of
 * the report and is intended to be used in test frameworks for generating detailed, customizable test reports.</p>
 *
 * <p><b>Usage:</b></p>
 * {@code
 * ExtentReportManager.setReportFilePath("./custom-output/test-report.html");
 * ExtentReportManager.initializeReport();
 * ExtentReportManager.createTest("Login Test");
 * ExtentReportManager.saveReport();
 * }
 *
 * <p>The report is generated at the location {@code ./extent-output/index.html} by default, but the path can
 * be customized using the {@code setReportFilePath} method.</p>
 *
 * @author Syed Anwer
 * @version 1.1
 * @since 2025-04-27
 */
public final class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;
    private static String reportFilePath = "./extent-output/index.html"; // Default file path

    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * <p>This constructor throws an {@link UnsupportedOperationException} if called,
     * as this class is designed to be used statically only.</p>
     */
    private ExtentReportManager() {
        throw new UnsupportedOperationException("Cannot instantiate ExtentReportManager: use static methods only.");
    }

    /**
     * Sets the file path for the report.
     *
     * @param filePath the custom path where the report will be saved.
     */
    public static void setReportFilePath(String filePath) {
        reportFilePath = filePath;
    }

    /**
     * Initializes the ExtentReports instance and attaches the ExtentSparkReporter to it and configures
     * the report properties.
     *
     * <p>This method ensures thread-safe initialization of the report and will initialize the report only once
     * in a multithreaded environment.</p>
     */
    public static void initializeReport() {
        if (Objects.isNull(extentReports)) synchronized (ExtentReportManager.class) {
            if (Objects.isNull(extentReports)) {
                extentReports = new ExtentReports();
                extentSparkReporter = new ExtentSparkReporter(new File(reportFilePath));
                configureReportProperties();
                attachSystemInfo();
            }
        }
    }

    /**
     * Creates a test entry in the report with the specified test name.
     *
     * @param testName the name of the test to create in the report
     */
    public static void createTest(String testName) {
        extentReports.createTest(testName);
    }

    /**
     * Finalizes and flushes the report, saving it to the disk.
     *
     * <p>This method must be called after all tests have been executed in order to generate the final report
     * and save it to the specified location.</p>
     */
    public static void saveReport() {
        extentReports.flush();
    }

    /**
     * Configures the visual and structural properties of the Extent report,
     * such as theme, document title, report name, and additional JavaScript customization.
     */
    private static void configureReportProperties() {
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("GPN Test Report");
        extentSparkReporter.config().setReportName("GPN Automation Report");
        extentSparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
    }

    /**
     * Attaches environment and system-related information to the Extent report,
     * including operating system details, Java version, execution environment, and the user who ran the tests.
     */
    private static void attachSystemInfo() {
        extentReports.setSystemInfo("Executed on OS & Java", System.getProperty("os.name") + " | Java " + System.getProperty("java.version"));
        extentReports.setSystemInfo("Executed on Environment", "Environment");
        extentReports.setSystemInfo("Executed by User", System.getProperty("user.name"));
    }

}
