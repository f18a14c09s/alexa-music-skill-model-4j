package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

/**
 * If an item's stream URI has expired, Alexa sends a GetItem request to obtain a new (refreshed) URI to begin playback on an Alexa device. This interface is optional. Implement this interface only if the stream URIs returned by your music service cloud can expire.
 * The primary use case for this API is when an item cached by Alexa is expired and needs to be refreshed. For example, a user is listening to music on their Alexa device, and then says "Alexa, pause". One hour later, the user says "Alexa, resume" but the stream URI for the item is now expired (based on the item's stream.validUntil field). In this scenario, Alexa calls GetItem to receive a new stream URI, and then sends the new stream URI to the device to resume playback.
 * If your skill does not expire stream URIs, or if the URI expiration period (stream.validUntil field) is always longer than 24 hours, your skill does not need to support the GetItem API. When a user pauses for an extended period of time (many hours), Alexa eventually forgets about the paused stream. In these cases, when a user later asks "Alexa, resume", Alexa asks the user what she or he would like to hear and then sends new GetPlayableContent and Initiate requests to the skill.
 */
@JsonDeserialize
public class GetItemRequest extends Request<GetItemRequest.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * An object containing context information about the request. See the RequestContext object for more information.
         */
        private RequestContext requestContext;
        /**
         * An object identifying the item to get. See the MediaReference object for more information.
         */
        private MediaReference<ItemReference> targetItemReference;
    }
}