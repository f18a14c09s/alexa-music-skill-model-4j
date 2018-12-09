package f18a14c09s.integration.alexa.music.data;

import f18a14c09s.integration.alexa.data.AbstractErrorResponse;
import lombok.Getter;
import lombok.Setter;

public class AudioErrorResponse extends AbstractErrorResponse<AudioErrorResponse.Payload> {
    @Getter
    @Setter
    public static final class Payload extends AbstractErrorResponse.Payload {
        private AudioErrorRetryPeriod retryPeriod;
    }
}
