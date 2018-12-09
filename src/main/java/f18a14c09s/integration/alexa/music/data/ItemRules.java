package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * Describes rules for what the user can do with an item. One example of a rule is whether the user can provide feedback about an audio item. Note that item level rules will override queue level rules.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRules {/**
 * Determine whether the user is allowed to provide feedback for a given item. Defaults to the flag specified in the QueueFeedbackRule.
 */
private Boolean feedbackEnabled;
}