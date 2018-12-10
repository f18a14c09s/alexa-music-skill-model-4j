package f18a14c09s.integration.alexa.music.data;

import java.util.*;

public enum PlaybackMethodType {
    ALEXA_AUDIO_PLAYER_QUEUE(PlaybackMethodTypeName.ALEXA_AUDIO_PLAYER_QUEUE);

    PlaybackMethodType(String myName) {
        if (!Objects.equals(myName, name())) {
            throw new IllegalArgumentException(String.format(
                    "%s name %s doesn't match %s (value passed into constructor).",
                    getClass().getSimpleName(),
                    name(),
                    myName));
        }
    }
}
