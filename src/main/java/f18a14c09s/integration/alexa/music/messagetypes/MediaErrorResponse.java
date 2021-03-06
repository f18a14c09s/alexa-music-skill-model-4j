package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.AbstractErrorResponse;
import lombok.NoArgsConstructor;

@JsonDeserialize
@NoArgsConstructor // No-arg constructor is used during deserialization.
public class MediaErrorResponse extends AbstractErrorResponse<AbstractErrorResponse.Payload> {

}
