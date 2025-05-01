package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import gitpractice.browser.BrowserManager;
import gitpractice.pages.login.LoginPages;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlfaDOCKTest extends BaseClass{

    @Test
    public void AlfaDOCKCustomerLoginTest() {
        BrowserManager.getDriver().get("https://www.alfadock-pack.com/");
        LoginPages loginPage = new LoginPages();
        loginPage.login();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The title of the page is : " + BrowserManager.getDriver().getTitle());
    }
}
