package gitpractice.enums;

/**
 * Enum representing different log levels used for test result logging.
 * Each log level corresponds to a different severity or status of a test.
 */
public enum LogLevel {
    PASS("Test passed successfully"),
    FAIL("Test failed, needs attention"),
    INFO("Information message"),
    SKIP("Test skipped"),
    FAIL_WITH_SCREENSHOT("Test failed with screenshot"),
    EXCEPTION_LOG("Exception or error occurred");

    private final String description;

    /**
     * Constructor to assign a description to each log level.
     *
     * @param description A brief description of the log level
     */
    LogLevel(String description) {
        this.description = description;
    }

    /**
     * Returns a human-readable description of the log level.
     *
     * @return the description of the log level
     */
    public String getDescription() {
        return description;
    }

    /**
     * Override toString() to return the log level description.
     *
     * @return the description of the log level
     */
    @Override
    public String toString() {
        return this.description;
    }
}
