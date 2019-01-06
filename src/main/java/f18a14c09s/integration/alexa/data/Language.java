package f18a14c09s.integration.alexa.data;

import lombok.Getter;

public enum Language {
    en("English");
    @Getter
    private final String fullName;

    Language(String fullName) {
        this.fullName = fullName;
    }
}
