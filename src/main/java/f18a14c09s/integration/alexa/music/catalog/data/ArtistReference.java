package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistReference {
    private String id;
    private ArrayList<EntityName> names;
    private ArrayList<AlternateNames> alternateNames;
}
