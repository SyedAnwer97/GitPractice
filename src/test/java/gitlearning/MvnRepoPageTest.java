package gitlearning;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class MvnRepoPageTest extends BaseClass{

    @Test
    public void mvnRepoTitleTest() {
        driver.get("https://mvnrepository.com/");
        driver.findElement(By.xpath("//a[@aria-label='Home']//*[name()='svg']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        System.out.println("The title of the page is : "  + driver.getTitle());
    }
}