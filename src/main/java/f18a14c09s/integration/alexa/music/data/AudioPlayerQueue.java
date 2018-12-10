package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioPlayerQueue extends PlaybackMethod {
    private String id;
    private ArrayList<QueueControl> controls;
    private QueueRules rules;
    private ArrayList<String> queueIdsToActivate;
    private Item firstItem;

    protected AudioPlayerQueue() {
        super(PlaybackMethodType.ALEXA_AUDIO_PLAYER_QUEUE);
    }
}
