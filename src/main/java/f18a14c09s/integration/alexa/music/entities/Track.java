package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Language;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import f18a14c09s.integration.alexa.music.metadata.TrackMetadata;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.*;
import java.util.stream.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
@Entity
@Table(name = RelationalTableName.TRACK)
@DiscriminatorValue(EntityTypeName.TRACK)
public class Track extends BaseEntity {
    @ElementCollection
    @CollectionTable(name = "song_languages", joinColumns = {
            @JoinColumn(name = "song_id", referencedColumnName = "id")})
    @Column(name = "content_language")
    @Enumerated(EnumType.STRING)
    private List<Language> languageOfContent;

    // Contradiction:
    // (1) The Alexa Music Skill documentation says that Track objects have the "releaseType" property
    //     (https://developer.amazon.com/docs/music-skills/catalog-reference.html#track);
    // but
    // (2) the Alexa Skill Kit's catalog service complains with the following error: "object instance has properties
    //     which are not allowed by the schema: [\"releaseType\"]."
    // The latter wins.
//    @Column(name = "release_type")
//    private String releaseType;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "song_artists", joinColumns = {
            @JoinColumn(name = "song_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "artist_id", referencedColumnName = "id")})
    private List<ArtistReference> artists;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "song_albums", joinColumns = {
            @JoinColumn(name = "song_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "album_id", referencedColumnName = "id")})
    private List<AlbumReference> albums;

    @JsonIgnore
    @Column(length = 4000)
    private String url;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "art_id", referencedColumnName = "id")
    private Art art;

    @JsonIgnore
    @Column(name = "duration_seconds")
    private Long durationSeconds;

    @JsonIgnore
    @Column(name = "natural_order")
    private Long naturalOrder;

    @Override
    public MediaMetadata toMediaMetadata() {
        TrackMetadata retval = new TrackMetadata();
        retval.setAlbum(Optional.ofNullable(getAlbums())
                .filter(albums -> !albums.isEmpty())
                .map(albums -> albums.get(0))
                .map(AlbumReference::toEntityMetadata)
                .orElse(null));
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
