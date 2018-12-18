package f18a14c09s.integration.alexa.music.entities;

import lombok.Getter;

import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.*;

@Getter
public enum EntityType {
    TRACK(EntityTypeName.TRACK, AMAZON_MUSIC_RECORDING),
    ALBUM(EntityTypeName.ALBUM, AMAZON_MUSIC_ALBUM),
    ARTIST(EntityTypeName.ARTIST, AMAZON_MUSIC_GROUP),
    PLAYLIST(EntityTypeName.PLAYLIST, AMAZON_MUSIC_PLAYLIST),
    GENRE(EntityTypeName.GENRE, AMAZON_GENRE),
    STATION(EntityTypeName.STATION, AMAZON_BROADCAST_CHANNEL),
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
