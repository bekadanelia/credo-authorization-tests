package ge.beka.credo.data;

import java.util.List;

public final class Language {

    public static final Language GEORGIAN = new Language("ქართული", "ქართ");
    public static final Language ENGLISH = new Language("English", "Eng");
    public static final Language RUSSIAN = new Language("Русский", "Рус");

    public static final List<Language> ALL = List.of(GEORGIAN, ENGLISH, RUSSIAN);

    public final String displayName;
    public final String expectedLabel;

    private Language(String displayName, String expectedLabel) {
        this.displayName = displayName;
        this.expectedLabel = expectedLabel;
    }
}
