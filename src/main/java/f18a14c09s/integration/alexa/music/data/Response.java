package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.AbstractMessage;

//@JsonDeserialize(using = ResponseDeserializer.class)
public abstract class Response<Payload> extends AbstractMessage<Payload> {
}
