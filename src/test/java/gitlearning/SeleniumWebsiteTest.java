package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import gitpractice.browser.BrowserManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWebsiteTest extends BaseClass {

    @Test
    public void checkDownloadsTabTest() {
        BrowserManager.getDriver().get("https://www.selenium.dev/");
        BrowserManager.getDriver().findElement(By.xpath("//a[@href='/downloads']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + BrowserManager.getDriver().getTitle());
    }

    @Test
    public void checkDocumentationTabTest() {
        BrowserManager.getDriver().get("https://www.selenium.dev/");
        BrowserManager.getDriver().findElement(By.xpath("//a[@href='/documentation']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + BrowserManager.getDriver().getTitle());
    }

    @Test
    public void checkProjectsTabTest() {
        BrowserManager.getDriver().get("https://www.selenium.dev/");
        BrowserManager.getDriver().findElement(By.xpath("//a[@href='/projects']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + BrowserManager.getDriver().getTitle());
    }
}
