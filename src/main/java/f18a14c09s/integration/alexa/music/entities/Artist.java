package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = RelationalTableName.ARTIST)
@DiscriminatorValue(EntityTypeName.ARTIST)
public class Artist extends BaseEntity {
    public ArtistReference toReference() {
        ArtistReference retval = new ArtistReference();
        retval.setAlternateNames(getAlternateNames());
        retval.setId(getId());
        retval.setNames(getNames());
        return retval;
    }
}
