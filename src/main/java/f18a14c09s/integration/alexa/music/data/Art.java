package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.*;

/**
 * Contains artwork for a media content.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "art")
public class Art {
    /**
     * Description of the art for accessibility purposes. Optional but recommended.
     */
    @Column(name = "content_description")
    private String contentDescription;
    /**
     * List of ArtSource objects each describing one size of the art. See the ArtSource object for more information.
     */
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "art_id", referencedColumnName = "id")
    private List<ArtSource> sources;

    @JsonIgnore
    @Id
    @GeneratedValue
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