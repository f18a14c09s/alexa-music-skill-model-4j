package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = RelationalTableName.GENRE)
@DiscriminatorValue(EntityTypeName.GENRE)
public class Genre extends BaseEntity {
}
