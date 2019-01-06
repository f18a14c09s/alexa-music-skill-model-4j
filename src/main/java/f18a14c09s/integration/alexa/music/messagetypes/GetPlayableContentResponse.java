package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.MessageHeader;
import f18a14c09s.integration.alexa.music.data.Content;
import lombok.Getter;
import lombok.Setter;

/**
 * @see GetPlayableContentRequest
 */
@JsonDeserialize
public class GetPlayableContentResponse extends Response<GetPlayableContentResponse.Payload> {
    /**
     * No-arg constructor is used during deserialization.
     */
    public GetPlayableContentResponse() {
        this(null);
    }

    public GetPlayableContentResponse(String messageId) {
        MessageHeader header = new MessageHeader();
        header.setNamespace(AlexaMediaSearch.NAMESPACE_NAME);
        header.setName(AlexaMediaSearch.GET_PLAYABLE_CONTENT_RESPONSE.getMyName());
        header.setPayloadVersion("1.0");
        header.setMessageId(messageId);
        setHeader(header);
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * Content that points to audio that satisfies the request.
         */
        private Content content;
    }
}