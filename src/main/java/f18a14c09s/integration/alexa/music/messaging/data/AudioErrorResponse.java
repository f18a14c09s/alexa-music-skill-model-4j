package f18a14c09s.integration.alexa.music.messaging.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.AbstractErrorResponse;
import f18a14c09s.integration.alexa.music.data.AudioErrorRetryPeriod;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize
public class AudioErrorResponse extends AbstractErrorResponse<AudioErrorResponse.Payload> {
    @Getter
    @Setter
    public static final class Payload extends AbstractErrorResponse.Payload {
        private AudioErrorRetryPeriod retryPeriod;
    }
}
