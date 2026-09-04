package ge.beka.credo.utils;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomDataGenerator {

    private RandomDataGenerator() {
    }

    public static String randomUsername() {
        return RandomStringUtils.secure().nextAlphabetic(8);
    }

    public static String randomPassword() {
        return RandomStringUtils.secure().nextAlphanumeric(10);
    }
}
