package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Playlist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicPlaylistCatalog extends AbstractCatalog<Playlist> {
    public MusicPlaylistCatalog() {
        super(null, null);
    }
}