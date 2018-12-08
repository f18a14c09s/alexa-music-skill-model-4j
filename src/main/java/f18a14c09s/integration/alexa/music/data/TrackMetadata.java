package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class TrackMetadata extends MediaMetadata {
    private ArrayList<EntityMetadata> authors;
    private EntityMetadata album;
}
