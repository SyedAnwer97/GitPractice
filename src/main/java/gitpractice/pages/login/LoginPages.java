package gitpractice.pages.login;

public class LoginPages {

    private CustomerLogin customerLogin;
    private UserLogin userLogin;
    private String customerNameAndPassword = "sch-dev";
    private String usernameAndPassword = "admin";

    public LoginPages() {
        this.customerLogin = new CustomerLogin();
        this.userLogin = new UserLogin();
    }

    public void login() {
        customerLogin.customerLogin(customerNameAndPassword, customerNameAndPassword)
                .userLogin(usernameAndPassword, usernameAndPassword);
    }
}
