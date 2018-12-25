package f18a14c09s.integration.alexa.music.metadata;

import com.fasterxml.jackson.annotation.JsonTypeName;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.data.MetadataNameProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName(MetadataTypeName.ARTIST)
public class ArtistMetadata extends MediaMetadata {
    public ArtistMetadata() {
        super(MetadataType.ARTIST);
    }

    public ArtistMetadata(MetadataNameProperty name, Art art) {
        super(MetadataType.ARTIST, name, art);
    }
}
