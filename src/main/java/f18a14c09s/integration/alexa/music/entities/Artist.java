package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.metadata.ArtistMetadata;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.Optional;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
public class Artist extends BaseEntity {
    @JsonIgnore
    private Art art;

    public ArtistReference toReference() {
        ArtistReference retval = new ArtistReference();
        retval.setAlternateNames(getAlternateNames());
        retval.setId(getId());
        retval.setNames(getNames());
        return retval;
    }

    @Override
    public MediaMetadata toMediaMetadata() {
        ArtistMetadata retval = new ArtistMetadata();
        retval.setArt(getArt());
        retval.setName(Optional.ofNullable(getNames())
                .filter(names -> !names.isEmpty())
                .map(names -> names.get(0))
                .filter(name -> name.getValue() != null)
                .map(EntityName::toMetadataNameProperty)
                .orElse(null));
        return retval;
    }
}
