package gitpractice.pages.login;

import gitpractice.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserLogin {

    private WebDriver driver;

    UserLogin() {
        this.driver = BrowserManager.getDriver();
    }

    private static final By txt_CompanyName = By.xpath("//div[@id='compName']");
    private static final By txtBox_Username = By.xpath("//input[@id='username']");
    private static final By txtBoxPassword = By.xpath("//input[@id='password']");
    private static final By btnLogin = By.xpath("//button[@id='login']");
    private static final By btnLogout = By.xpath("//button[@id='logout']");

    public UserLogin enterUsername(String username) {
        driver.findElement(txtBox_Username).sendKeys(username);
        return this;
    }

    public UserLogin enterPassword(String password) {
        driver.findElement(txtBoxPassword).sendKeys(password);
        return this;
    }

    public UserLogin clickLogin() {
        driver.findElement(btnLogin).click();
        return this;
    }

    public UserLogin clickLogout() {
        driver.findElement(btnLogout).click();
        return this;
    }

    public void userLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_CompanyName));
        enterUsername(username).enterPassword(password).clickLogin();
    }

}
