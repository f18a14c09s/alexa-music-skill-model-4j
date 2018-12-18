package f18a14c09s.integration.alexa.music.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "music_entities")
@DiscriminatorColumn(name = "type")
public abstract class BaseEntityReference {
    @Id
    private String id;
}
