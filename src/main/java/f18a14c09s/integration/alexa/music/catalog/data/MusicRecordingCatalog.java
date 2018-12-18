package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Track;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_RECORDING;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
//@Table(name = "song_catalogs")
//@Table(name = "music_catalogs")
@DiscriminatorValue(AMAZON_MUSIC_RECORDING)
public class MusicRecordingCatalog extends AbstractCatalog {
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "catalog_songs", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "song_id", referencedColumnName = "id")})
    private List<Track> entities;

    public MusicRecordingCatalog() {
        super(AMAZON_MUSIC_RECORDING, 2.0);
    }
}