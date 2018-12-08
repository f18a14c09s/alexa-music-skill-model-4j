package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item2 {
    private String id;
    private PlaybackInfo4 playbackInfo;
    private Metadata4 metadata;
    private Long durationInMilliseconds;
    private ArrayList<Controls5> controls;
    private Rules5 rules;
    private Stream4 stream;
    private Feedback5 feedback;
}