package gitlearning;

import gitpractice.browser.BrowserManger;
import gitpractice.enums.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    private final static Browser BROWSER = Browser.CHROME;

    @BeforeMethod
    public void setup() {
        BrowserManger.initBrowser(BROWSER);
    }

    @AfterMethod
    public void tearDown() {
        BrowserManger.tearDownBrowser();
    }
}