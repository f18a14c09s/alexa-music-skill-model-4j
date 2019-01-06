package f18a14c09s.integration.alexa.data;

import lombok.Getter;

public enum Country {
    US("United States of America");
    @Getter
    private final String fullName;

    Country(String fullName) {
        this.fullName = fullName;
    }
}
