package gitpractice.pages;

import gitpractice.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginComp {

    private static final By DROPDOWN_LANGUAGE = By.id("mySelect");
    private static final By TEXTBOX_CUSTOMER_NAME = By.id("username");
    private static final By TEXTBOX_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("logmein");

    public void selectLanguage() {
        Select select = new Select(Browser.getBrowser().findElement(DROPDOWN_LANGUAGE));
        select.selectByVisibleText("English");
    }

    public void enterUsername() {
        Browser.getBrowser().findElement(TEXTBOX_CUSTOMER_NAME).sendKeys("sch-dev");
    }

    public void enterPassword() {
        Browser.getBrowser().findElement(TEXTBOX_PASSWORD).sendKeys("sch-dev");
    }

    public void clickLoginButton() {
        Browser.getBrowser().findElement(BTN_LOGIN).click();
    }

}
