package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_GENRE;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@DiscriminatorValue(AMAZON_GENRE)
public class GenreCatalog extends AbstractCatalog {
    @ManyToMany
    @JoinTable(name = "catalog_genres", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private List<Genre> entities;

    public GenreCatalog() {
        super(null, null);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.Genre";
    }
}