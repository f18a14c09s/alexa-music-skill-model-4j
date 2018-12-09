package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * Captures the details of how Alexa should render text in voice prompts to the user.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeechInfo {
}