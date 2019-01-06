package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.AbstractMessage;
import f18a14c09s.integration.alexa.music.RequestDeserializer;
import f18a14c09s.integration.alexa.music.data.RequestContext;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(using = RequestDeserializer.class)
public abstract class Request<Payload> extends AbstractMessage<Payload> {
    @Getter
    @Setter
    public static abstract class AbstractPayload {
        /**
         * An object containing context information about the request. See the RequestContext object for more information.
         */
        private RequestContext requestContext;
    }
}
