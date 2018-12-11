package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album extends BaseEntity {
    private ArrayList<EntityName> names;
    private Popularity popularity;
    private ArrayList<AlternateNames> alternateNames;
    private ArrayList<String> languageOfContent;
    private String releaseType;
    private ArrayList<ArtistReference> artists;
}
