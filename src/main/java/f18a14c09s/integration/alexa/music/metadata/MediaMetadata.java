package f18a14c09s.integration.alexa.music.metadata;

import f18a14c09s.integration.alexa.music.data.MetadataNameProperty;
import f18a14c09s.integration.alexa.music.data.Art;

public abstract class MediaMetadata extends BaseMetadata {
    protected MediaMetadata(MetadataType type) {
        super(type);
    }

    protected MediaMetadata(MetadataType type, MetadataNameProperty name, Art art) {
        super(type, name, art);
    }
}
