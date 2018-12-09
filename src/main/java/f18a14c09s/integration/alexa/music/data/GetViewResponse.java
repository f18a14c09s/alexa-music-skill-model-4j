package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import f18a14c09s.integration.alexa.data.Response;/**
 * @see GetViewRequest
 */
@JsonDeserialize
public class GetViewResponse extends Response<GetViewResponse.Payload> {
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public static final class Payload {/**
 * List of QueueControl objects that Alexa uses to determine which controls to enable in the Alexa app. See the QueueControl object for more information.
 */
private ArrayList queueControls;/**
 * A list of Item objects representing the active queue. The maximum length of the list is ten items. The list should always include the currently playing Item. If the response contains more than ten items, Alexa discards the extra items. For more information, see the Item object.
 */
private ArrayList items;
}
}