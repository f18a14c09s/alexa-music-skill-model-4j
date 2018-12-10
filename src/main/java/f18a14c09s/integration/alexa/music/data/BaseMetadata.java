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
        @JsonSubTypes.Type(value = TrackMetadata.class, name = MediaMetadata.MediaMetadataTypeName.TRACK),
        @JsonSubTypes.Type(value = AdMetadata.class, name = MetadataTypeName.AD)})
public abstract class BaseMetadata<Type extends Enum<Type>> {
    private Type type;
    private MetadataNameProperty name;
    private Art art;
}
