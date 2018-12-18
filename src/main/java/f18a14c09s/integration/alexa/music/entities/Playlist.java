package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = RelationalTableName.PLAYLIST)
@DiscriminatorValue(EntityTypeName.PLAYLIST)
public class Playlist extends BaseEntity {
}
