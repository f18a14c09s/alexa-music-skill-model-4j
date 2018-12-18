package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Album;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_ALBUM;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
//@Table(name = "album_catalogs")
//@Table(name = "music_catalogs")
@DiscriminatorValue(AMAZON_MUSIC_ALBUM)
public class MusicAlbumCatalog extends AbstractCatalog {
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "catalog_albums", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "album_id", referencedColumnName = "id")})
    private List<Album> entities;

    public MusicAlbumCatalog() {
        super(AMAZON_MUSIC_ALBUM, 2.0);
    }
}