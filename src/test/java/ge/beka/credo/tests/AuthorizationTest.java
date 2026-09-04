package ge.beka.credo.tests;

import ge.beka.credo.base.BaseTest;
import ge.beka.credo.data.LoginCredentialsDataProvider;
import ge.beka.credo.data.SecurityPayloads;
import ge.beka.credo.pages.AuthorizationPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Authorization")
public class AuthorizationTest extends BaseTest {

    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginCredentialsDataProvider.class)
    public void loginWithMissingOrInvalidCredentials(String language, String expectedLanguageLabel, String scenario, String username, String password) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualLanguageLabel, expectedLanguageLabel,
                "Language button label should update after switching language");

        authorizationPage.loginForm()
                .enterUsername(username)
                .enterPassword(password)
                .submit();

        if (username.equals(SecurityPayloads.XSS_PAYLOAD)) {
            verifyNoAlertPresent(softAssert);
        }

        verifyErrorBannerDisplayed(authorizationPage, username, password, softAssert);

        softAssert.assertAll();
    }

    @Step("Verify no JavaScript alert was triggered")
    private void verifyNoAlertPresent(SoftAssert softAssert) {
        try {
            driver.switchTo().alert().dismiss();
            softAssert.fail("XSS payload triggered a JavaScript alert");
        } catch (NoAlertPresentException expected) {
        }
    }

    @Step("Verify the wrong credentials error banner is displayed")
    private void verifyErrorBannerDisplayed(AuthorizationPage authorizationPage, String username, String password, SoftAssert softAssert) {
        if (!username.isEmpty() && !password.isEmpty()) {
            softAssert.assertTrue(authorizationPage.errorBanner().isDisplayed(),
                    "Wrong credentials error banner should be displayed");
        }
    }
}
