package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.MessageHeader;
import f18a14c09s.integration.alexa.music.data.Item;
import lombok.Getter;
import lombok.Setter;

/**
 * @see GetPreviousItemRequest
 */
@JsonDeserialize
public class GetPreviousItemResponse extends Response<GetPreviousItemResponse.Payload> {
    /**
     * No-arg constructor is used during deserialization.
     */
    public GetPreviousItemResponse() {
        this(null, null);
    }

    public GetPreviousItemResponse(String messageId, Item item) {
        MessageHeader header = new MessageHeader();
        header.setNamespace(AlexaAudioPlayQueue.NAMESPACE_NAME);
        header.setName(AlexaAudioPlayQueue.GET_PREVIOUS_ITEM_RESPONSE.getMyName());
        header.setPayloadVersion("1.0");
        header.setMessageId(messageId);
        setHeader(header);
        GetPreviousItemResponse.Payload payload = new GetPreviousItemResponse.Payload();
        payload.setItem(item);
        setPayload(payload);
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * The previous item in the play queue. See the Item object for more information.
         */
        private Item item;
    }
}