package f18a14c09s.integration.alexa.music.metadata;

import java.util.*;

public enum MetadataType {
    ALBUM(MetadataTypeName.ALBUM),
    ARTIST(MetadataTypeName.ARTIST),
    GENRE(MetadataTypeName.GENRE),
    PLAYLIST(MetadataTypeName.PLAYLIST),
    STATION(MetadataTypeName.STATION),
    TRACK(MetadataTypeName.TRACK),
    AD(MetadataTypeName.AD);

    MetadataType(String myName) {
        if (!Objects.equals(myName, name())) {
            throw new IllegalArgumentException(String.format(
                    "%s name %s doesn't match %s (value passed into constructor).",
                    getClass().getSimpleName(),
                    name(),
                    myName));
        }
    }
}
