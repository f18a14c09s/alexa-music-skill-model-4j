package f18a14c09s.integration.alexa.music.messaging.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.data.Item;
import lombok.Getter;
import lombok.Setter;

/**
 * @see GetItemRequest
 */
@JsonDeserialize
public class GetItemResponse extends Response<GetItemResponse.Payload> {
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public static final class Payload {/**
 * The requested item in the play queue. See the Item object for more information.
 */
private Item item;
}
}