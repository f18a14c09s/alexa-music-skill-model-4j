package f18a14c09s.integration.alexa.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractMessage<Payload> extends BaseMessage {
    private Payload payload;
}
