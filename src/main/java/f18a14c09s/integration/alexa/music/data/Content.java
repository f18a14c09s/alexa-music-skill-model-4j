package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content<Metadata extends MediaMetadata> {
    private String id;
    private Actions actions;
    private Metadata metadata;

    @Getter
    @Setter
    public static final class Actions {
        private Boolean playable;
        private Boolean browsable;
    }
}
