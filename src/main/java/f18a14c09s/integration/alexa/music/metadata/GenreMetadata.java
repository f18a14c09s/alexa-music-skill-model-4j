package f18a14c09s.integration.alexa.music.metadata;

import com.fasterxml.jackson.annotation.JsonTypeName;
import f18a14c09s.integration.alexa.music.data.EntityMetadata;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonTypeName(MetadataTypeName.GENRE)
public class GenreMetadata extends MediaMetadata {
    private ArrayList<EntityMetadata> authors;

    public GenreMetadata() {
        super(MetadataType.GENRE);
    }
}
