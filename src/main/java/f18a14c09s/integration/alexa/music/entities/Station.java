package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station extends BaseEntity {
    private Long channelId;
    private String callSign;
    private String frequency;
    private String ownedAndOperated;
    private List<Language> languageOfContent;
}
