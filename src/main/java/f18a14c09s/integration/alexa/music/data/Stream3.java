package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream3 {
    private String id;
    private String uri;
    private Long offsetInMilliseconds;
    private String validUntil;
}