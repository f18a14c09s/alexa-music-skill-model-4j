package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.data.Art;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = RelationalTableName.TRACK)
@DiscriminatorValue(EntityTypeName.TRACK)
public class Track extends BaseEntity {
    @ElementCollection
    @CollectionTable(name = "song_languages", joinColumns = {
            @JoinColumn(name = "song_id", referencedColumnName = "id")})
    @Column(name = "content_language")
    private List<String> languageOfContent;

    @Column(name = "release_type")
    private String releaseType;

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
}
