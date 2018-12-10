package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.messaging.data.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * When music is playing on an Alexa device and the user makes a request to enable or disable shuffle mode, Alexa sends a SetShuffle request to the skill. This interface is optional. Implement this interface only if your music service supports shuffle mode.
 * Whenever a user asks for music to be shuffled, or to turn off shuffle, Alexa sends a SetShuffle request. Example utterances include "Alexa, shuffle" and "Alexa, turn off shuffle". A SetShuffle request likely changes the skill's response to the next GetNextItem request. The skill must persist the current shuffle state (on or off) and associate it to the currently playing queue of music.
 * For example, when a user is listening to an album with shuffle mode off, a GetNextItem response should return the next track in the album. If shuffle mode is turned on by the user (Alexa sends a SetShuffle request with "enable": true), the skill should shuffle the album queue and respond to the next GetNextItem request with an out-of-order track. If shuffle mode is turned off by the user (Alexa sends a SetShuffle request with "enable": false), the skill should respond to the next GetNextItem request with the following track in the album.
 * The Initiate request determines the initial shuffle mode for the queue. The Initiate request contains a playbackModes.shuffle property that indicates whether to turn shuffle on or off for the queue. After a queue is created, SetShuffle can change the shuffle mode while music from the queue is playing.
 * After Alexa sends a SetShuffle request, Alexa discards the next item in the queue because changing the shuffle mode likely changes which track should be played next. Therefore, immediately after a SetShuffle request, Alexa sends a GetNextItem request to prepare the correct next track to play.
 */
@JsonDeserialize
public class SetShuffleRequest extends Request<SetShuffleRequest.Payload> {
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
        private MediaReference<ItemReference> currentItemReference;
        /**
         * A flag that indicates whether to enable or disable shuffle mode.
         */
        private Boolean enable;
    }
}