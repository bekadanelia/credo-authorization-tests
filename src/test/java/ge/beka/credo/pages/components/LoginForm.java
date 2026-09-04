package ge.beka.credo.pages.components;

import ge.beka.credo.pages.AuthorizationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class LoginForm {

    private final AuthorizationPage page;

    public LoginForm(AuthorizationPage page) {
        this.page = page;
    }

    @Step("Enter username: {0}")
    public LoginForm enterUsername(String username) {
        WebElement usernameField = page.usernameLocator();
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Enter password: {0}")
    public LoginForm enterPassword(String password) {
        WebElement passwordField = page.passwordLocator();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Submit the login form")
    public LoginForm submit() {
        page.submitLocator().click();
        return this;
    }
}
