package f18a14c09s.integration.alexa.music.data.new1;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageHeader {

    private String messageId;

    // TODO: Deserialization will fail on this field until it is annotated or written with custom deserialization.
    private MessageNamespace namespace;

    private Enum<?> name;

    private String payloadVersion;

}
