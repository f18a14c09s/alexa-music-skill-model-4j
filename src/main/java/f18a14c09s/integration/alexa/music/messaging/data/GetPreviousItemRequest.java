package f18a14c09s.integration.alexa.music.messaging.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.data.ItemReference;
import f18a14c09s.integration.alexa.music.data.RequestContext;
import lombok.Getter;
import lombok.Setter;

/**
 * Alexa sends a GetPreviousItem request to the skill when a content queue exists and playback has started on the Alexa device, and one of the following is true:
 */
@JsonDeserialize
public class GetPreviousItemRequest extends Request<GetPreviousItemRequest.Payload> {
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public static final class Payload {/**
 * An object containing context information about the request. See the RequestContext object for more information.
 */
private RequestContext requestContext;/**
 * An object identifying the currently playing item. See the ItemReference object for more information.
 */
private ItemReference currentItemReference;
}
}