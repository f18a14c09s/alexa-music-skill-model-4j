package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Album;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_ALBUM;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicAlbumCatalog extends AbstractCatalog {
    private List<Album> entities;

    public MusicAlbumCatalog() {
        super(AMAZON_MUSIC_ALBUM, 2.0);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.MusicAlbum";
    }
}