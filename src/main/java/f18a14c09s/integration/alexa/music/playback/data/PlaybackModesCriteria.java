package f18a14c09s.integration.alexa.music.playback.data;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaybackModesCriteria {
    private Boolean shuffle;
    private Boolean loop;
    private HashMap<String, Object> repeat;
}
