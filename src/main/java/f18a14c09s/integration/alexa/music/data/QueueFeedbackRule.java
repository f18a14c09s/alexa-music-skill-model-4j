package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * An object that describes whether feedback of a specific type is allowed at the queue level.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueueFeedbackRule {
    public QueueFeedbackRule() {
        this(null);
    }

    public QueueFeedbackRule(Boolean enabled) {
        setType(Feedback.Type.PREFERENCE);
        setEnabled(enabled);
    }

    /**
     * The type of feedback. The only supported value is PREFERENCE.
     */
    private Feedback.Type type;
    /**
     * Whether feedback should be enabled. If false, Alexa will render error prompts (VUI) or show error messages (GUI) when the user tries to provide feedback. Note that this flag can be overridden on an item-by-item basis.
     */
    private Boolean enabled;
}