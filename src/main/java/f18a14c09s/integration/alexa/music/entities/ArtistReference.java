package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.EntityMetadata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
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
