package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.EntityMetadata;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
@Entity
@Table(name = RelationalTableName.ARTIST)
@DiscriminatorValue(EntityTypeName.ARTIST)
public class ArtistReference extends BaseEntityReference {
    public EntityMetadata toEntityMetadata() {
        EntityMetadata retval = new EntityMetadata();
        retval.setName(Optional.ofNullable(getNames())
                .filter(names -> !names.isEmpty())
                .map(names -> names.get(0))
                .filter(name -> name.getValue() != null)
                .map(EntityName::toMetadataNameProperty)
                .orElse(null));
        return retval;
    }
}
