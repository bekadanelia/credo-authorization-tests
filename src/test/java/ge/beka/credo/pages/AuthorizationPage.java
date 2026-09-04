package ge.beka.credo.pages;

import ge.beka.credo.pages.components.ErrorBanner;
import ge.beka.credo.pages.components.LanguageSwitcher;
import ge.beka.credo.pages.components.LoginForm;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BasePage {

    private static final String URL = "https://mycredo.ge/landing/main/authorization";

    private static final By USERNAME = By.xpath("//input[@id='username']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By SUBMIT = By.xpath("//button[@aria-label='sign in']");
    private static final By WRONG_CREDENTIALS_TOAST = By.xpath("//div[@role='alert' and contains(@class,'error')]");

    private LoginForm loginForm;
    private ErrorBanner errorBanner;
    private LanguageSwitcher languageSwitcher;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the authorization page")
    public AuthorizationPage open() {
        driver.get(URL);
        languageSwitcher = new LanguageSwitcher(driver);
        return this;
    }

    @Step("Load username, password, and error elements")
    public AuthorizationPage loadLoginComponents() {
        wait.until(ExpectedConditions.presenceOfElementLocated(USERNAME));
        loginForm = new LoginForm(this);
        errorBanner = new ErrorBanner(WRONG_CREDENTIALS_TOAST, driver);
        return this;
    }

    public WebElement usernameLocator() {
        return driver.findElement(USERNAME);
    }

    public WebElement passwordLocator() {
        return driver.findElement(PASSWORD);
    }

    public WebElement submitLocator() {
        return driver.findElement(SUBMIT);
    }

    public LoginForm loginForm() {
        return loginForm;
    }

    public ErrorBanner errorBanner() {
        return errorBanner;
    }

    public LanguageSwitcher languageSwitcher() {
        return languageSwitcher;
    }
}
