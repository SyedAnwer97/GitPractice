package gitpractice.pages.login;

import gitpractice.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerLogin {

    private WebDriver driver;

    CustomerLogin() {
        driver = BrowserManager.getDriver();
    }

    private static final By DROPDOWN_LANGUAGE = By.id("mySelect");
    private static final By TEXTBOX_CUSTOMER_NAME = By.id("username");
    private static final By TEXTBOX_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("logmein");

    public CustomerLogin selectLanguage() {
        Select select = new Select(driver.findElement(DROPDOWN_LANGUAGE));
        select.selectByVisibleText("English");
        return this;
    }

    public CustomerLogin enterUsername(String customerName) {
        driver.findElement(TEXTBOX_CUSTOMER_NAME).sendKeys(customerName);
        return this;
    }

    public CustomerLogin enterPassword(String password) {
        driver.findElement(TEXTBOX_PASSWORD).sendKeys(password);
        return this;
    }

    public UserLogin clickLoginButton() {
        driver.findElement(BTN_LOGIN).click();
        return new UserLogin();
    }

    public UserLogin customerLogin(String customerName, String password) {
        return selectLanguage().enterUsername(customerName).enterPassword(password).clickLoginButton();
    }
}
