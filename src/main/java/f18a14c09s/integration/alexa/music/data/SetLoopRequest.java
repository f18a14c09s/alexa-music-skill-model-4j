package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import f18a14c09s.integration.alexa.data.Request;

@JsonDeserialize
public class SetLoopRequest extends Request<SetLoopRequest.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        private RequestContext6 requestContext;
        private CurrentItemReference4 currentItemReference;
        private Boolean enable;
    }
}