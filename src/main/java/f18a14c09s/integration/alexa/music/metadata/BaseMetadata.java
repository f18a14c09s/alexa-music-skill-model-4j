package f18a14c09s.integration.alexa.music.metadata;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import f18a14c09s.integration.alexa.data.MetadataNameProperty;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.data.ResolvedSelectionCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ResolvedSelectionCriteria.BasicEntityAttribute.class, visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = AlbumMetadata.class, name = MetadataTypeName.ALBUM),
        @JsonSubTypes.Type(value = ArtistMetadata.class, name = MetadataTypeName.ARTIST),
        @JsonSubTypes.Type(value = GenreMetadata.class, name = MetadataTypeName.GENRE),
        @JsonSubTypes.Type(value = PlaylistMetadata.class, name = MetadataTypeName.PLAYLIST),
        @JsonSubTypes.Type(value = StationMetadata.class, name = MetadataTypeName.STATION),
        @JsonSubTypes.Type(value = TrackMetadata.class, name = MetadataTypeName.TRACK),
        @JsonSubTypes.Type(value = AdMetadata.class, name = MetadataTypeName.AD)})
public abstract class BaseMetadata {
    private MetadataType type;
    private MetadataNameProperty name;
    private Art art;

    protected BaseMetadata(MetadataType type) {
        this.type = type;
    }

    protected BaseMetadata(MetadataType type, MetadataNameProperty name, Art art) {
        this.type = type;
        this.name = name;
        this.art = art;
    }
}
