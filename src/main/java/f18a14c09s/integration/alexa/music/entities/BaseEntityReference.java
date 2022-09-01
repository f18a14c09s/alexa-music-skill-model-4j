package f18a14c09s.integration.alexa.music.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "music_entities")
@DiscriminatorColumn(name = "type")
public abstract class BaseEntityReference {
    @Id
    private String id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "entity_entity_names", joinColumns = {
            @JoinColumn(name = "entity_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "name_id", referencedColumnName = "id")})
    private List<EntityName> names = Collections.emptyList();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "entity_alt_names", joinColumns = {
            @JoinColumn(name = "entity_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "alt_name_id", referencedColumnName = "id")})
    private List<AlternateNames> alternateNames;
}
