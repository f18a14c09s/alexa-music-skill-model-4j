package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.data.Filters;
import f18a14c09s.integration.alexa.music.data.ItemMediaReference;
import f18a14c09s.integration.alexa.music.data.RequestContext;
import f18a14c09s.integration.alexa.music.playback.data.PlaybackModesCriteria;
import lombok.Getter;
import lombok.Setter;

/**
 * When Alexa receives a content identifier from a skill's GetPlayableContent response and is ready to start immediate playback of the content on an Alexa device, Alexa sends an Initiate request. The request includes the content identifier, and the skill responds with the stream URI for immediate playback of the content.
 * There are four primary scenarios that cause Alexa to call this API:
 */
@JsonDeserialize
public class InitiateRequest extends Request<InitiateRequest.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * An object containing context information about the request. See the RequestContext object for more information.
         */
        private RequestContext requestContext;
        /**
         * Filters to apply during content resolution. See the Filters object for more information.
         */
        private Filters filters;
        /**
         * Identifies the content to use for creating a playback queue.
         */
        private String contentId;
        /**
         * An identifier for the item that is currently playing (active) on the target endpoint, if any. See the MediaReference object for more information. Note that this property is absent when nothing is playing. Your skill should use this property to enforce concurrency limits. More specifically, you can use it to determine whether the playback session will start on an endpoint where no stream is playing, or it will replace an existing stream on an endpoint.
         */
        private ItemMediaReference currentItemReference;
        /**
         * An object describing the playback mode requirements. See the PlaybackModesCriteria object for more information. If the user did not mention anything about a looped or shuffled queue, this attribute defaults to false for all supported playback modes.
         */
        private PlaybackModesCriteria playbackModes;
    }
}