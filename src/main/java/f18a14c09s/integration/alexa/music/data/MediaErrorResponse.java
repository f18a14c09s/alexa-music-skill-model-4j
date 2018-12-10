package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.AbstractErrorResponse;

@JsonDeserialize
public class MediaErrorResponse extends AbstractErrorResponse<AbstractErrorResponse.Payload> {

}
