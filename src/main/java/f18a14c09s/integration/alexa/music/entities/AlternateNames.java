package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "alternate_names")
public class AlternateNames {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    private String language;
    @ElementCollection
    @CollectionTable(name = "alt_name_values", joinColumns = {
            @JoinColumn(name = "alt_names_id", referencedColumnName = "id")})
    @Column(name = "alt_name")
    private List<String> values;
}
