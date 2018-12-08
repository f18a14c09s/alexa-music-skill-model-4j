package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import f18a14c09s.integration.alexa.data.Response;

@JsonDeserialize
public class GenericResponse extends Response<GenericResponse.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
    }
}