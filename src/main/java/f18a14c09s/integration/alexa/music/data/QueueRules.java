package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * Identifies rules that apply to all items in the play queue.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueueRules {/**
 * Used to identify whether feedback of a specific type is allowed for a queue. If absent, Alexa assumes that no type of feedback is supported for this queue. See QueueFeedbackRule for details. Note that enablement of feedback can be overridden at the item level.
 */
private QueueFeedbackRule feedback;
}