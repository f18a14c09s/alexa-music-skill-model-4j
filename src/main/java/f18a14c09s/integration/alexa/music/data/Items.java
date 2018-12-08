package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    private String id;
    private PlaybackInfo playbackInfo;
    private Metadata metadata;
    private Long durationInMilliseconds;
    private ArrayList<Controls> controls;
    private Rules rules;
    private Stream stream;
    private Feedback feedback;
}