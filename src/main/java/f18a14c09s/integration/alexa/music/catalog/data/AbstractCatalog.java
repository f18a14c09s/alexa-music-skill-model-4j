package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import f18a14c09s.integration.alexa.music.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "music_catalogs")
//@MappedSuperclass
//@SequenceGenerator(name = "catalog_id_sequence", sequenceName = "catalog_id_sequence", initialValue = 1, allocationSize = 100)
@DiscriminatorColumn(name = "type")
public abstract class AbstractCatalog {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    @Column(insertable = false, updatable = false)
    private String type;
    private Double version;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "catalog_locales", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "locale_id", referencedColumnName = "id")})
    private List<Locale> locales;

    protected AbstractCatalog(String type, Double version, Locale... locales) {
        this.type = type;
        this.version = version;
        this.locales =
                new ArrayList<>(Optional.ofNullable(locales).map(Arrays::asList).orElse(Collections.emptyList()));
    }

    public abstract <E extends BaseEntity> List<E> getEntities();
}
