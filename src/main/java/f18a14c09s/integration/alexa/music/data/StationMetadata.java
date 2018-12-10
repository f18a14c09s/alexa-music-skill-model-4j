package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonTypeName(MediaMetadata.MediaMetadataTypeName.STATION)
public class StationMetadata extends MediaMetadata {
    private ArrayList<EntityMetadata> authors;
}
