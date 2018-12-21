package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.Art;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = RelationalTableName.ARTIST)
@DiscriminatorValue(EntityTypeName.ARTIST)
public class Artist extends BaseEntity {
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "art_id", referencedColumnName = "id")
    private Art art;

    public ArtistReference toReference() {
        ArtistReference retval = new ArtistReference();
        retval.setAlternateNames(getAlternateNames());
        retval.setId(getId());
        retval.setNames(getNames());
        return retval;
    }
}
