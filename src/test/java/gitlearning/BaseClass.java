package gitlearning;

import gitpractice.browser.BrowserManger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    private final static String BROWSER = "firefox";

    @BeforeMethod
    public void setup() {
        BrowserManger.initBrowser(BROWSER);
    }

    @AfterMethod
    public void tearDown() {
        BrowserManger.tearDownBrowser();
    }
}