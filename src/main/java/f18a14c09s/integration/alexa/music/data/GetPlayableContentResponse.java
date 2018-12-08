package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.data.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonDeserialize
public class GetPlayableContentResponse extends Response<GetPlayableContentResponse.Payload> {
    @Getter
    @Setter
    public static final class Payload {
        private Content content;
    }
}
