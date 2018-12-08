package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.Request;
import f18a14c09s.integration.alexa.data.RequestContext;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize
public class GetPlayableContentRequest extends Request<GetPlayableContentRequest.Payload> {
    @Getter
    @Setter
    public static final class Payload {
        private RequestContext requestContext;
        private Filters filters;
        private ResolvedSelectionCriteria selectionCriteria;
    }
}
