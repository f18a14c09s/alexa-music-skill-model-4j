package f18a14c09s.integration.alexa.music.data;

public class MediaMetadata extends BaseMetadata<MediaMetadata.Type> {
    public enum Type {
        ALBUM,
        ARTIST,
        GENRE,
        PLAYLIST,
        STATION,
        TRACK
    }
}
