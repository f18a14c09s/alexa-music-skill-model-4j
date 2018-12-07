package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class AudioPlayerQueue extends PlaybackMethod {
    private String id;
    private ArrayList<QueueControl> controls;
    private Object rules;
    private Object queueIdsToDeactivate;
    private String firstItem;

    public AudioPlayerQueue() {
        super(Type.ALEXA_AUDIO_PLAYER_QUEUE);
    }
}
