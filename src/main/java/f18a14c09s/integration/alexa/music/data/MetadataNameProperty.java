package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import f18a14c09s.integration.alexa.data.SpeechInfo;

/**
 * Metadata used for voice prompt or display use cases of entity (artist, song, etc.) names.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataNameProperty {
    /**
     * Name of the entity to be used in Alexa voice prompts. See the SpeechInfo object for details.
     */
    private SpeechInfo speech;
    /**
     * Name of the entity to be used in display use cases such as in the Alexa app. Currently the Alexa service ignores this field.
     */
    private String display;
}