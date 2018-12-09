package f18a14c09s.integration.alexa.music.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

/**
 * When music is playing on an Alexa device and the user navigates to the "play queue" view in the Alexa app, Alexa sends a GetView request to the skill. The skill responds with the item currently playing and (optionally) a list of up to ten upcoming items for display in the app. Alexa uses the response only for display in the Alexa app so that users can see the items that are coming up next.
 */
@JsonDeserialize
public class GetViewRequest extends Request<GetViewRequest.Payload> {
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public static final class Payload {/**
 * An object containing context information about the request. See the RequestContext object for more information.
 */
private RequestContext requestContext;/**
 * An object identifying the currently playing item. The skill should use the identifiers here to find the play queue for which Alexa is requesting items. See the ItemReference object for more information.
 */
private ItemReference currentItemReference;
}
}