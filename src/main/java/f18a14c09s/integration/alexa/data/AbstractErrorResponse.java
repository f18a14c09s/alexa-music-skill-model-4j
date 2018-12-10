package f18a14c09s.integration.alexa.data;

import f18a14c09s.integration.alexa.music.messagetypes.Response;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractErrorResponse<PayloadImpl extends AbstractErrorResponse.Payload> extends Response<PayloadImpl> {
    @Getter
    @Setter
    public static class Payload {
        private ErrorResponseType type;
        private String message;
    }
}
