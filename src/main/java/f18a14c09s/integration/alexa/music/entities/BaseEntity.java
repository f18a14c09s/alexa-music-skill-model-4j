package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "music_entities")
@DiscriminatorColumn(name = "type")
public abstract class BaseEntity {
    @Id
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
    @Column(name = "last_updated_time")
    private Calendar lastUpdatedTime;

    private Boolean deleted;

    @ManyToMany
    @JoinTable(name = "entity_locales", joinColumns = {
            @JoinColumn(name = "entity_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "locale_id", referencedColumnName = "id")})
    private List<Locale> locales;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "popularity_id", referencedColumnName = "id")
    private Popularity popularity;

    public BaseEntity() {
    }

    public BaseEntity(String id,
                      Calendar lastUpdatedTime,
                      Boolean deleted,
                      List<Locale> locales,
                      List<EntityName> names,
                      List<AlternateNames> alternateNames,
                      Popularity popularity) {
        this.id = id;
        this.lastUpdatedTime = lastUpdatedTime;
        this.deleted = deleted;
        this.locales = locales;
        this.names = names;
        this.alternateNames = alternateNames;
        this.popularity = popularity;
    }

    public MediaMetadata toMediaMetadata() {
        return null;
    }
}
