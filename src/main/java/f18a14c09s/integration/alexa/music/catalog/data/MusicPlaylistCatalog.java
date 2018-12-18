package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Playlist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicPlaylistCatalog extends AbstractCatalog {
    @ManyToMany
    @JoinTable(name = "catalog_playlists", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "playlist_id", referencedColumnName = "id")})
    private List<Playlist> entities;

    public MusicPlaylistCatalog() {
        super(null, null);
    }
}