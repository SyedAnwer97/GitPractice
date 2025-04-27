package gitpractice.pages;

import gitpractice.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginComp {

    private static final By DROPDOWN_LANGUAGE = By.id("mySelect");
    private static final By TEXTBOX_CUSTOMER_NAME = By.id("username");
    private static final By TEXTBOX_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("logmein");

    public void selectLanguage() {
        Select select = new Select(BrowserManager.getDriver().findElement(DROPDOWN_LANGUAGE));
        select.selectByVisibleText("English");
    }

    public void enterUsername() {
        BrowserManager.getDriver().findElement(TEXTBOX_CUSTOMER_NAME).sendKeys("sch-dev");
    }

    public void enterPassword() {
        BrowserManager.getDriver().findElement(TEXTBOX_PASSWORD).sendKeys("sch-dev");
    }

    public void clickLoginButton() {
        BrowserManager.getDriver().findElement(BTN_LOGIN).click();
    }

}
