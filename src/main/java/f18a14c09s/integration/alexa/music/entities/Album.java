package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = RelationalTableName.ALBUM)
@DiscriminatorValue(EntityTypeName.ALBUM)
public class Album extends BaseEntity {
    @ElementCollection
    @CollectionTable(name = "album_languages", joinColumns = {
            @JoinColumn(name = "album_id", referencedColumnName = "id")})
    @Column(name = "content_language")
    private List<String> languageOfContent;

    @Column(name = "release_type")
    private String releaseType;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "album_artists", joinColumns = {
            @JoinColumn(name = "album_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "artist_id", referencedColumnName = "id")})
    private List<ArtistReference> artists;

    public AlbumReference toReference() {
        AlbumReference retval = new AlbumReference();
        retval.setAlternateNames(getAlternateNames());
        retval.setId(getId());
        retval.setNames(getNames());
        retval.setReleaseType(getReleaseType());
        return retval;
    }
}
