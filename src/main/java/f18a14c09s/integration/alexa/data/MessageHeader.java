package f18a14c09s.integration.alexa.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageHeader {
    private String payloadVersion;
    private String namespace;
    private String name;
    private String messageId;
}
