package ge.beka.credo.data;

import ge.beka.credo.utils.RandomDataGenerator;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.List;

public final class LoginCredentialsDataProvider {

    private LoginCredentialsDataProvider() {
    }

    @DataProvider(name = "loginCredentials")
    public static Object[][] loginCredentials() {
        List<Object[]> rows = new ArrayList<>();
        for (Language language : Language.ALL) {
            String languageName = language.displayName;
            String expectedLabel = language.expectedLabel;
            rows.add(new Object[]{languageName, expectedLabel, "Empty username, filled password", "", RandomDataGenerator.randomPassword()});
            rows.add(new Object[]{languageName, expectedLabel, "Filled username, empty password", RandomDataGenerator.randomUsername(), ""});
            rows.add(new Object[]{languageName, expectedLabel, "Both fields empty", "", ""});
            rows.add(new Object[]{languageName, expectedLabel, "Both fields filled", RandomDataGenerator.randomUsername(), RandomDataGenerator.randomPassword()});
            rows.add(new Object[]{languageName, expectedLabel, "SQL injection attempt", SecurityPayloads.SQL_INJECTION_PAYLOAD, SecurityPayloads.SQL_INJECTION_PAYLOAD});
            rows.add(new Object[]{languageName, expectedLabel, "XSS attempt", SecurityPayloads.XSS_PAYLOAD, SecurityPayloads.XSS_PAYLOAD});
            rows.add(new Object[]{languageName, expectedLabel, "Username with leading/trailing whitespace", SecurityPayloads.WHITESPACE_USERNAME, RandomDataGenerator.randomPassword()});
        }
        return rows.toArray(new Object[0][]);
    }
}