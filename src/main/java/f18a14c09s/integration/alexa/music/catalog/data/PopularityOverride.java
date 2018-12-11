package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopularityOverride {
    private Locale locale;
    private Long value;
}
