package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "popularity")
public class Popularity {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("default")
    private Long myDefault;

    @Getter
    @Setter
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "popularity_pop_override", joinColumns = {
            @JoinColumn(name = "popularity_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "pop_override_id", referencedColumnName = "id")})
    private List<PopularityOverride> overrides = Collections.emptyList();

    public Popularity() {
    }

    public Popularity(Long myDefault, ArrayList<PopularityOverride> overrides) {
        this.myDefault = myDefault;
        this.overrides = overrides;
    }

    public Long getDefault() {
        return myDefault;
    }

    public void setDefault(Long myDefault) {
        this.myDefault = myDefault;
    }

    public static Popularity unratedWithNoOverrides() {
        return new Popularity(0L, null);
    }
}
