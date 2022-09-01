package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Language;
import f18a14c09s.integration.alexa.music.data.Art;
import f18a14c09s.integration.alexa.music.metadata.AlbumMetadata;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
public class Album extends BaseEntity {
    private List<Language> languageOfContent;

    private String releaseType;

    private List<ArtistReference> artists;

    @JsonIgnore
    private Art art;

    /**
     * Example influences of this value:
     * (*) Release year;
     * (*) File system directory name that contains the album's tracks;
     * (*) Album name.
     */
    @JsonIgnore
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
