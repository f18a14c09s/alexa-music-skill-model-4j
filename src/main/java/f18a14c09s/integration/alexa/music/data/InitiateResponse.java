package f18a14c09s.integration.alexa.music.data;

import f18a14c09s.integration.alexa.data.Response;
import lombok.Getter;
import lombok.Setter;

public class InitiateResponse extends Response<PlaybackMethod> {
    @Getter
    @Setter
    public static final class Payload {
        private PlaybackMethod playbackMethod;
    }
}
