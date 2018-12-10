package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * Contains metadata for an ad item.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName(MetadataTypeName.AD)
public class AdMetadata extends BaseMetadata<AdMetadata.Type> {
    public enum Type {
        AD
    }
}