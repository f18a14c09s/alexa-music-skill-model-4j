package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Station;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BroadcastChannelCatalog extends AbstractCatalog {
    private List<Station> entities;

    public BroadcastChannelCatalog() {
        super(null, null);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.BroadcastChannel";
    }
}