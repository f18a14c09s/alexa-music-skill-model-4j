package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Track;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_RECORDING;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicRecordingCatalog extends AbstractCatalog {
    private List<Track> entities;

    public MusicRecordingCatalog() {
        super(AMAZON_MUSIC_RECORDING, 2.0);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.MusicRecording";
    }
}