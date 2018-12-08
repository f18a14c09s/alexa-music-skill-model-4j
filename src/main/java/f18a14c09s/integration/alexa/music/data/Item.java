package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String id;
    private PlaybackInfo1 playbackInfo;
    private Metadata1 metadata;
    private Long durationInMilliseconds;
    private ArrayList<Controls1> controls;
    private Rules1 rules;
    private Stream1 stream;
    private Feedback1 feedback;
}