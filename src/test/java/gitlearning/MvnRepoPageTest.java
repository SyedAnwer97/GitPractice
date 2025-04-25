package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import gitpractice.browser.Browser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class MvnRepoPageTest extends BaseClass {

    @Test
    public void mvnRepoTitleTest() {
        Browser.getBrowser().get("https://mvnrepository.com/");
        Browser.getBrowser().findElement(By.xpath("//a[@aria-label='Home']//*[name()='svg']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The title of the page is : " + Browser.getBrowser().getTitle());
    }
}