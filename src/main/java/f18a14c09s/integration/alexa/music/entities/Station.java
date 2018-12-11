package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station extends BaseEntity {
    private ArrayList<EntityName> names;
    private Popularity popularity;
    private ArrayList<AlternateNames> alternateNames;
    private Long channelId;
    private String callSign;
    private String frequency;
    private String ownedAndOperated;
    private ArrayList<String> languageOfContent;
}
