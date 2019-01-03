package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.metadata.AlbumMetadata;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.util.stream.*;

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

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "art_id", referencedColumnName = "id")
    private Art art;

    /**
     * Example influences of this value:
     * (*) Release year;
     * (*) File system directory name that contains the album's tracks;
     * (*) Album name.
     */
    @JsonIgnore
    @Column(name = "natural_order")
    private Long naturalOrder;

    public AlbumReference toReference() {
        AlbumReference retval = new AlbumReference();
        retval.setAlternateNames(getAlternateNames());
        retval.setId(getId());
        retval.setNames(getNames());
        retval.setReleaseType(getReleaseType());
        return retval;
    }

    @Override
    public MediaMetadata toMediaMetadata() {
        AlbumMetadata retval = new AlbumMetadata();
        retval.setAuthors(Optional.ofNullable(getArtists())
                .map(Collection::stream)
                .orElse(Stream.empty())
                .map(ArtistReference::toEntityMetadata)
                .collect(Collectors.toCollection(ArrayList::new)));
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
