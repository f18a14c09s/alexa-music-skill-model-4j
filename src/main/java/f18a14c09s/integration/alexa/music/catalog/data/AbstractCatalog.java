package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import f18a14c09s.integration.alexa.music.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractCatalog {
    @JsonIgnore
    private Long id;
    private String type;
    private Double version;
    private List<Locale> locales;

    protected AbstractCatalog(String type, Double version, Locale... locales) {
        this.type = type;
        this.version = version;
        this.locales =
                new ArrayList<>(Optional.ofNullable(locales).map(Arrays::asList).orElse(Collections.emptyList()));
    }

    public abstract <E extends BaseEntity> List<E> getEntities();

    @JsonIgnore
    public abstract String getDefaultUsage();
}
