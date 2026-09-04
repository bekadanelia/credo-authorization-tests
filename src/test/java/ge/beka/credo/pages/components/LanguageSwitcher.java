package ge.beka.credo.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSwitcher {

    private static final By LANGUAGE_BUTTON = By.xpath("//button[.//app-icon[@svgicon='language']]");

    private static By languageOption(String languageName) {
        return By.xpath("//li[.//p[text()='" + languageName + "']]");
    }

    private WebElement languageButton() {
        return driver.findElement(LANGUAGE_BUTTON);
    }

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LanguageSwitcher(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Open the language dropdown")
    public LanguageSwitcher open() {
        wait.until(ExpectedConditions.elementToBeClickable(LANGUAGE_BUTTON)).click();
        return this;
    }

    @Step("Select language: {0}")
    public LanguageSwitcher selectLanguage(String languageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(languageOption(languageName))).click();
        return this;
    }

    @Step("Wait for language label to become: {0}")
    public String waitForLanguageLabel(String expectedLabel) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(LANGUAGE_BUTTON, expectedLabel));
        } catch (TimeoutException ignored) {
        }
        return languageButton().getText();
    }
}
