package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PlaybackMethod {
    private Type type;

    public PlaybackMethod(Type type) {
        this.type = type;
    }

    public enum Type {
        ALEXA_AUDIO_PLAYER_QUEUE
    }
}
