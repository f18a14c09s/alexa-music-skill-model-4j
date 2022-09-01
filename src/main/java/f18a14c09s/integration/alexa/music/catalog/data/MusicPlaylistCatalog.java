package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Playlist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicPlaylistCatalog extends AbstractCatalog {
    private List<Playlist> entities;

    public MusicPlaylistCatalog() {
        super(null, null);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.MusicPlaylist";
    }
}