package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.metadata.ArtistMetadata;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = RelationalTableName.ARTIST)
@DiscriminatorValue(EntityTypeName.ARTIST)
@NamedQueries({@NamedQuery(name = "Artist.getPlayableContent", query = "SELECT o FROM Artist o WHERE o.id = :id")})
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
