package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.Request;
import f18a14c09s.integration.alexa.data.RequestContext;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize
public class InitiateRequest extends Request<InitiateRequest.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        private RequestContext requestContext;
        private Filters filters;
        private String contentId;
        private MediaReference<String, ItemReference> currentItemReference;
        private PlaybackModesCriteria playbackModes;
    }
}
