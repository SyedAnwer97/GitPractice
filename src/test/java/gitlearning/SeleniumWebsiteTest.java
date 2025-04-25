package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import gitpractice.browser.Browser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWebsiteTest extends BaseClass {

    @Test
    public void checkDownloadsTabTest() {
        Browser.getBrowser().get("https://www.selenium.dev/");
        Browser.getBrowser().findElement(By.xpath("//a[@href='/downloads']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + Browser.getBrowser().getTitle());
    }

    @Test
    public void checkDocumentationTabTest() {
        Browser.getBrowser().get("https://www.selenium.dev/");
        Browser.getBrowser().findElement(By.xpath("//a[@href='/documentation']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + Browser.getBrowser().getTitle());
    }

    @Test
    public void checkProjectsTabTest() {
        Browser.getBrowser().get("https://www.selenium.dev/");
        Browser.getBrowser().findElement(By.xpath("//a[@href='/projects']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + Browser.getBrowser().getTitle());
    }
}
