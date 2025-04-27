package gitpractice.pages;

public class CustomerLoginPage {

    private CustomerLoginComp customerLoginComp;

    public CustomerLoginPage() {
        this.customerLoginComp = new CustomerLoginComp();
    }

    public void login() {
        customerLoginComp.selectLanguage();
        customerLoginComp.enterUsername();
        customerLoginComp.enterPassword();
        customerLoginComp.clickLoginButton();
    }
}
