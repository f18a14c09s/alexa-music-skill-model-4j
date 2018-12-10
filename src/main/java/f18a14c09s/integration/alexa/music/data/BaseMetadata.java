package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import f18a14c09s.integration.alexa.data.MetadataNameProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ResolvedSelectionCriteria.BasicEntityAttribute.class, visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = AlbumMetadata.class, name = MediaMetadata.MediaMetadataTypeName.ALBUM),
        @JsonSubTypes.Type(value = ArtistMetadata.class, name = MediaMetadata.MediaMetadataTypeName.ARTIST),
        @JsonSubTypes.Type(value = GenreMetadata.class, name = MediaMetadata.MediaMetadataTypeName.GENRE),
        @JsonSubTypes.Type(value = PlaylistMetadata.class, name = MediaMetadata.MediaMetadataTypeName.PLAYLIST),
        @JsonSubTypes.Type(value = StationMetadata.class, name = MediaMetadata.MediaMetadataTypeName.STATION),
        @JsonSubTypes.Type(value = TrackMetadata.class, name = MediaMetadata.MediaMetadataTypeName.TRACK),
        @JsonSubTypes.Type(value = AdMetadata.class, name = MetadataTypeName.AD)})
public abstract class BaseMetadata<Type extends Enum<Type>> {
    private Type type;
    private MetadataNameProperty name;
    private Art art;
}
