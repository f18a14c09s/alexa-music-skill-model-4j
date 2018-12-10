package f18a14c09s.integration.alexa.music.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import static f18a14c09s.integration.alexa.music.metadata.MetadataType.AD;

/**
 * Contains metadata for an ad item.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName(MetadataTypeName.AD)
public class AdMetadata extends BaseMetadata {
    public AdMetadata() {
        super(AD);
    }
}