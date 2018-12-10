package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.*;

//@JsonSubTypes({@JsonSubTypes.Type(value = AlbumMetadata.class, name = MediaMetadata.MediaMetadataTypeName.ALBUM),
//        @JsonSubTypes.Type(value = TrackMetadata.class, name = MediaMetadata.MediaMetadataTypeName.TRACK)})
public abstract class MediaMetadata extends BaseMetadata<MediaMetadata.Type> {
    public enum Type {
        ALBUM(MediaMetadataTypeName.ALBUM),
        ARTIST(MediaMetadataTypeName.ARTIST),
        GENRE(MediaMetadataTypeName.GENRE),
        PLAYLIST(MediaMetadataTypeName.PLAYLIST),
        STATION(MediaMetadataTypeName.STATION),
        TRACK(MediaMetadataTypeName.TRACK);

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

    public static final class MediaMetadataTypeName {
        public static final String ALBUM = "ALBUM";
        public static final String ARTIST = "ARTIST";
        public static final String GENRE = "GENRE";
        public static final String PLAYLIST = "PLAYLIST";
        public static final String STATION = "STATION";
        public static final String TRACK = "TRACK";
    }
}
