package f18a14c09s.integration.alexa.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize(using = ResponseDeserializer.class)
public abstract class Response<Payload> extends AbstractMessage<Payload> {
}
