package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import gitpractice.browser.BrowserManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class MvnRepoPageTest extends BaseClass {

    @Test
    public void mvnRepoTitleTest() {
        BrowserManager.getDriver().get("https://mvnrepository.com/");
        BrowserManager.getDriver().findElement(By.xpath("//a[@aria-label='Home']//*[name()='svg']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The title of the page is : " + BrowserManager.getDriver().getTitle());
    }
}