package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;

/**
 * Contains artwork for a media content.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
public class Art {
    /**
     * Description of the art for accessibility purposes. Optional but recommended.
     */
    private String contentDescription;
    /**
     * List of ArtSource objects each describing one size of the art. See the ArtSource object for more information.
     */
    private List<ArtSource> sources;

    @JsonIgnore
    private Long id;

    public Art() {
    }

    public Art(List<ArtSource> sources) {
        this(null, sources);
    }

    public Art(String contentDescription, List<ArtSource> sources) {
        this.contentDescription = contentDescription;
        this.sources = sources;
    }
}