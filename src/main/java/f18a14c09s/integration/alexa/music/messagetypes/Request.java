package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.AbstractMessage;
import f18a14c09s.integration.alexa.music.RequestDeserializer;

@JsonDeserialize(using = RequestDeserializer.class)
public abstract class Request<Payload> extends AbstractMessage<Payload> {
}
