package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.EntityMetadata;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = RelationalTableName.ALBUM)
@DiscriminatorValue(EntityTypeName.ALBUM)
public class AlbumReference extends BaseEntityReference {
    @Column(name = "release_type")
    private String releaseType;

    @JsonIgnore
    @Column(name = "natural_order")
    private Long naturalOrder;

    @Override
    public String toString() {
        return String.format("%s %s", getClass().getSimpleName(), getId());
    }

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
