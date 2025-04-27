package gitlearning;

import gitpractice.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    private final static gitpractice.enums.Browser BROWSER = gitpractice.enums.Browser.FIREFOX;

    @BeforeMethod
    public void setup() {
        Browser.initBrowser(BROWSER);
    }

    @AfterMethod
    public void tearDown() {
        Browser.tearDownBrowser();
    }
}