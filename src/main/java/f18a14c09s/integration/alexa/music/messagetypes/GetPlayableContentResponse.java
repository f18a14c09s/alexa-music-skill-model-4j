package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.data.Content;
import lombok.Getter;
import lombok.Setter;

/**
 * @see GetPlayableContentRequest
 */
@JsonDeserialize
public class GetPlayableContentResponse extends Response<GetPlayableContentResponse.Payload> {
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Payload {
        /**
         * Content that points to audio that satisfies the request.
         */
        private Content content;
    }
}