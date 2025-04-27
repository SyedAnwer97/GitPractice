package gitpractice.enums;

/**
 * Enum representing the supported browsers in the application.
 * This enum can be expanded to include additional properties or methods related to each browser.
 *
 * @author Syed Anwer
 * @version 1.0
 * @since 2025-04-27
 */
public enum Browser {
    /**
     * Represents Google Chrome browser.
     */
    CHROME("Google Chrome"),

    /**
     * Represents Mozilla Firefox browser.
     */
    FIREFOX("Mozilla Firefox"),

    /**
     * Represents Microsoft Edge browser.
     */
    EDGE("Microsoft Edge");

    private final String displayName;

    /**
     * Private constructor to associate a display name with each enum constant.
     *
     * @param displayName the display name of the browser.
     */
    private Browser(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the browser.
     *
     * @return the display name of the browser.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Override toString to return the display name for the browser.
     *
     * @return the display name of the browser.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
