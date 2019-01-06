package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.MessageHeader;
import f18a14c09s.integration.alexa.music.playback.data.PlaybackMethod;
import lombok.Getter;
import lombok.Setter;

/**
 * @see InitiateRequest
 */
@JsonDeserialize
public class InitiateResponse extends Response<InitiateResponse.Payload> {
    /**
     * No-arg constructor is used during deserialization.
     */
    public InitiateResponse() {
        this(null, null);
    }

    public InitiateResponse(String messageId, PlaybackMethod playbackMethod) {
        MessageHeader header = new MessageHeader();
        header.setNamespace(AlexaMediaPlayback.NAMESPACE_NAME);
        header.setName(AlexaMediaPlayback.INITIATE_RESPONSE.getMyName());
        header.setPayloadVersion("1.0");
        header.setMessageId(messageId);
        setHeader(header);
        Payload payload = new Payload();
        payload.setPlaybackMethod(playbackMethod);
        setPayload(payload);
    }

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