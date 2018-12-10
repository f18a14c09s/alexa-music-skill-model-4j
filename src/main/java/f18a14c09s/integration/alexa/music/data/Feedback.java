package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Describes the user's feedback or preference about an item. For example, if the user said "I like this" while a song was playing.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feedback {
    /**
     * The type of feedback. This only supported value is PREFERENCE.
     */
    private Type type;
    /**
     * The value of feedback. Can be either POSITIVE or NEGATIVE.
     */
    private Value value;

    public enum Type {
        PREFERENCE
    }

    public enum Value {
        POSITIVE,
        NEGATIVE
    }
}