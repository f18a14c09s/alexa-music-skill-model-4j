package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirstItem {
    private String id;
    private PlaybackInfo2 playbackInfo;
    private Metadata2 metadata;
    private Long durationInMilliseconds;
    private ArrayList<Controls3> controls;
    private Rules3 rules;
    private Stream2 stream;
    private Feedback3 feedback;
}