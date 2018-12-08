package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ResolvedSelectionCriteria.BasicEntityAttribute.class, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AudioPlayerQueue.class, name = PlaybackMethod.PlaybackMethodTypeName.ALEXA_AUDIO_PLAYER_QUEUE)})
public abstract class PlaybackMethod {
    private Type type;

    public PlaybackMethod(Type type) {
        this.type = type;
    }

    public enum Type {
        ALEXA_AUDIO_PLAYER_QUEUE(PlaybackMethodTypeName.ALEXA_AUDIO_PLAYER_QUEUE);

        Type(String myName) {
            if (!Objects.equals(myName, name())) {
                throw new IllegalArgumentException(String.format(
                        "%s name %s doesn't match %s (value passed into constructor).",
                        getClass().getSimpleName(),
                        name(),
                        myName));
            }
        }
    }

    public static final class PlaybackMethodTypeName {
        public static final String ALEXA_AUDIO_PLAYER_QUEUE = "ALEXA_AUDIO_PLAYER_QUEUE";
    }
}
