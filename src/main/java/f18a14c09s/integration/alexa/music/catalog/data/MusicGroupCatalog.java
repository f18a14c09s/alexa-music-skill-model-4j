package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Artist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_GROUP;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicGroupCatalog extends AbstractCatalog {
    private List<Artist> entities;

    public MusicGroupCatalog() {
        super(AMAZON_MUSIC_GROUP, 2.0);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.MusicGroup";
    }
}