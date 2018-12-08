package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;

import java.util.*;

@Getter
public enum EntityType {
    TRACK(EntityTypeName.TRACK, "AMAZON.MusicRecording"),
    ALBUM(EntityTypeName.ALBUM, "AMAZON.MusicAlbum"),
    ARTIST(EntityTypeName.ARTIST, "AMAZON.MusicGroup"),
    PLAYLIST(EntityTypeName.PLAYLIST, "AMAZON.MusicPlaylist"),
    GENRE(EntityTypeName.GENRE, "AMAZON.Genre"),
    STATION(EntityTypeName.STATION, "AMAZON.BroadcastChannel"),
    MEDIA_TYPE(EntityTypeName.MEDIA_TYPE),
    SORT_TYPE(EntityTypeName.SORT_TYPE);
    private final String catalogType;

    EntityType(String myName) {
        this(myName, null);
    }

    EntityType(String myName, String catalogType) {
        this.catalogType = catalogType;
        if (!Objects.equals(myName, name())) {
            throw new IllegalArgumentException(String.format(
                    "%s name %s doesn't match %s (value passed into constructor).",
                    getClass().getSimpleName(),
                    name(),
                    myName));
        }
    }
}
