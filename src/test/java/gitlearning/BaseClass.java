package gitlearning;

import gitpractice.browser.BrowserManger;
import gitpractice.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver = null;
    private final static Browser BROWSER = Browser.CHROME;

    @BeforeMethod
    public void setup() {
        driver = BrowserManger.initBrowser(BROWSER);
    }

    @AfterMethod
    public void tearDown() {
        BrowserManger.tearDownBrowser();
    }
}