package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Artist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_GROUP;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
//@Table(name = "artist_catalogs")
//@Table(name = "music_catalogs")
@DiscriminatorValue(AMAZON_MUSIC_GROUP)
public class MusicGroupCatalog extends AbstractCatalog {
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "catalog_artists", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "artist_id", referencedColumnName = "id")})
    private List<Artist> entities;

    public MusicGroupCatalog() {
        super(AMAZON_MUSIC_GROUP, 2.0);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.MusicGroup";
    }
}