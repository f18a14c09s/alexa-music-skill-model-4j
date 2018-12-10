package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.playback.data.PlaybackMethod;
import lombok.Getter;
import lombok.Setter;

/**
 * @see InitiateRequest
 */
@JsonDeserialize
public class InitiateResponse extends Response<InitiateResponse.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * A polymorphic object containing information about the playback method that Alexa should use to achieve playback for the user. See the PlaybackMethod object for more information.
         */
        private PlaybackMethod playbackMethod;
    }
}