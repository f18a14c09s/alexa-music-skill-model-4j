package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.messagetypes.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * When music is playing on an Alexa device and the user makes a request to enable or disable loop mode, Alexa sends a SetLoop request to the skill. This interface is optional. Implement this interface only if your music service supports loop mode.
 * Whenever a user asks for music to be looped, or to turn off loop, Alexa sends a SetLoop request. The skill must persist the current loop state (on or off) and associate it to the currently playing queue of music.
 * For example, when a user is listening to the last track of an album with loop mode off, a GetNextItem response should indicate that there are no more items in the queue ("isQueueFinished": true). However, when a user turns on loop mode (Alexa sends a SetLoop request with "enable": true), a GetNextItem response should return the first track of the album when the last track of the album is playing. Similarly, with loop mode on, a GetPreviousItem response should return the last track of the album when the first track is playing.
 * The Alexa Music Skill API does not provide a way for a user to ask for music to start playing with loop mode on. When music is playing, however, the user can turn on or off loop mode through voice commands such as "Alexa, loop" or "Alexa, turn off loop".
 */
@JsonDeserialize
public class SetLoopRequest extends Request<SetLoopRequest.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * An object containing context information about the request. See the RequestContext object for more information.
         */
        private RequestContext requestContext;
        /**
         * An object identifying the currently playing item. See the ItemReference object for more information.
         */
        private ItemMediaReference currentItemReference;
        /**
         * A flag that indicates whether to enable or disable loop mode.
         */
        private Boolean enable;
    }
}