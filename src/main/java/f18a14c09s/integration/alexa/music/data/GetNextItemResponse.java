package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import f18a14c09s.integration.alexa.data.Response;/**
 * @see GetNextItemRequest
 */
@JsonDeserialize
public class GetNextItemResponse extends Response<GetNextItemResponse.Payload> {
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public static final class Payload {/**
 * A flag that indicates whether the currently playing item is the last item in the queue. When this value is false, the item field must be present and contain a non-null value. When this value is true, the item field must be absent or set to null.
 */
private Boolean isQueueFinished;/**
 * The requested item in the play queue. See the Item object for more information.
 */
private Item item;
}
}