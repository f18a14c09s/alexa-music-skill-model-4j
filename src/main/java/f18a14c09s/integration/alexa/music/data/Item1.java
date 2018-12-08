package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item1 {
    private String id;
    private PlaybackInfo3 playbackInfo;
    private Metadata3 metadata;
    private Long durationInMilliseconds;
    private ArrayList<Controls4> controls;
    private Rules4 rules;
    private Stream3 stream;
    private Feedback4 feedback;
}