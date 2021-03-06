package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonDeserialize
@NoArgsConstructor // No-arg constructor is used during deserialization.
public class GenericResponse extends Response<GenericResponse.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
    }
}