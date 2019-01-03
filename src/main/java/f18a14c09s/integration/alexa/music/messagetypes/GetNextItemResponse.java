package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.MessageHeader;
import f18a14c09s.integration.alexa.music.data.Item;
import lombok.Getter;
import lombok.Setter;

/**
 * @see GetNextItemRequest
 */
@JsonDeserialize
public class GetNextItemResponse extends Response<GetNextItemResponse.Payload> {
    public GetNextItemResponse(String messageId, Item item) {
        MessageHeader header = new MessageHeader();
        header.setNamespace(AlexaAudioPlayQueue.NAMESPACE_NAME);
        header.setName(AlexaAudioPlayQueue.GET_NEXT_ITEM_RESPONSE.getMyName());
        header.setPayloadVersion("1.0");
        header.setMessageId(messageId);
        setHeader(header);
        GetNextItemResponse.Payload payload = new GetNextItemResponse.Payload();
        payload.setItem(item);
        payload.setIsQueueFinished(item == null);
        setPayload(payload);
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * A flag that indicates whether the currently playing item is the last item in the queue. When this value is false, the item field must be present and contain a non-null value. When this value is true, the item field must be absent or set to null.
         */
        private Boolean isQueueFinished;
        /**
         * The requested item in the play queue. See the Item object for more information.
         */
        private Item item;
    }
}