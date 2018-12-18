package f18a14c09s.integration.alexa.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "locales")
public class Locale {
    public static Locale en_US() {
        return new Locale("US", "en");
    }

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String language;

    public Locale() {
    }

    public Locale(String country, String language) {
        this.country = country;
        this.language = language;
    }
}
