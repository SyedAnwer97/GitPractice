package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWebsiteTest extends BaseClass {

    @Test
    public void checkDownloadsTabTest() {
        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//a[@href='/downloads']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + driver.getTitle());
    }

    @Test
    public void checkDocumentationTabTest() {
        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//a[@href='/documentation']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + driver.getTitle());
    }

    @Test
    public void checkProjectsTabTest() {
        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//a[@href='/projects']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The document page title is : " + driver.getTitle());
    }
}
