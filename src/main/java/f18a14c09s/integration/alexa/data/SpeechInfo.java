package f18a14c09s.integration.alexa.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeechInfo {
    private SpeechType type;
    private String text;

    public enum SpeechType {
        PLAIN_TEXT
    }
}