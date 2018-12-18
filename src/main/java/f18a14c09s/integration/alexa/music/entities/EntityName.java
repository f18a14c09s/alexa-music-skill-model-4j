package f18a14c09s.integration.alexa.music.entities;

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
@Table(name = "entity_names")
public class EntityName {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    private String language;
    private String value;

    public EntityName() {
    }

    public EntityName(String language, String value) {
        this.language = language;
        this.value = value;
    }
}
