package f18a14c09s.integration.alexa.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static f18a14c09s.integration.alexa.data.Country.US;
import static f18a14c09s.integration.alexa.data.Language.en;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "locales")
public class Locale {
    public static Locale en_US() {
        return new Locale(US, en);
    }

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Language language;

    public Locale() {
    }

    public Locale(Country country, Language language) {
        this.country = country;
        this.language = language;
    }
}
