package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicGroupCatalog extends AbstractCatalog<Artist> {
    public MusicGroupCatalog() {
        super(null, null);
    }
}