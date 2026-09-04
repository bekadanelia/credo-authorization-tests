package ge.beka.credo.base;

import ge.beka.credo.data.Language;
import ge.beka.credo.pages.AuthorizationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;
    protected AuthorizationPage authorizationPage;
    protected String actualLanguageLabel;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    @Step("Open the authorization page and switch language")
    public void switchLanguage(Object[] params) {
        String language = (String) params[0];
        String expectedLanguageLabel = (String) params[1];

        authorizationPage = new AuthorizationPage(driver).open();

        if (!language.equals(Language.GEORGIAN.displayName)) {
            authorizationPage.languageSwitcher().open().selectLanguage(language);
        }
        actualLanguageLabel = authorizationPage.languageSwitcher().waitForLanguageLabel(expectedLanguageLabel);

        authorizationPage.loadLoginComponents();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
