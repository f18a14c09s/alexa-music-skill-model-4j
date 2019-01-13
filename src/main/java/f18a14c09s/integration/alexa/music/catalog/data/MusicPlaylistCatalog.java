package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Playlist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_PLAYLIST;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@DiscriminatorValue(AMAZON_MUSIC_PLAYLIST)
public class MusicPlaylistCatalog extends AbstractCatalog {
    @ManyToMany
    @JoinTable(name = "catalog_playlists", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "playlist_id", referencedColumnName = "id")})
    private List<Playlist> entities;

    public MusicPlaylistCatalog() {
        super(null, null);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.MusicPlaylist";
    }
}