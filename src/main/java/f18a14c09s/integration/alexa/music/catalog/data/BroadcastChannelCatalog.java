package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Station;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BroadcastChannelCatalog extends AbstractCatalog<Station> {
    public BroadcastChannelCatalog() {
        super(null, null);
    }
}