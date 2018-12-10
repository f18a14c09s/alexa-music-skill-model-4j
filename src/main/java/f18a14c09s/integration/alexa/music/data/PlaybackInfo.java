package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * An object that describes which business rules Alexa should run when playing an item. More specifically:
 * For advertisements, Alexa will follow these rules:
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaybackInfo {/**
 * The type of playback info. The field can have one of the following values: DEFAULT - describes an item that is neither a sample nor an ad SAMPLE - describes an item whose stream is a shorter version of a full track AD - describes an item whose stream is an advertisement
 */
private String type;
}