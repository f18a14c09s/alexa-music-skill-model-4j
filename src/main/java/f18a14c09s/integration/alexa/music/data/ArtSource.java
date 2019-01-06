package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Contains information about a single size of a media content's art (for example, album cover art).
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "art_sources")
public class ArtSource {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    /**
     * The URL for the image of this size. URL must be HTTPS.
     */
    @Column(length = 4000)
    private String url;
    /**
     * The size for the image. Alexa can use this optional field to help determine which size of ArtSource to use. If the skill knows the exact image dimensions and populates widthPixels or heightPixels, the skill should also populate this field to the appropriate size based on those values. However, this field can be populated without having to specify widthPixels or heightPixels if unknown. If an image size is unknown then this field can be left blank. Valid values and recommended image sizes for each: "X_SMALL" (recommended for images approximately 48 x 48 pixels) "SMALL" (recommended for 60 x 60 pixels) "MEDIUM" (recommended for 110 x 110 pixels) "LARGE" (recommended for 256 x 256 pixels) "X_LARGE" (recommended for 600 x 600 pixels)
     */
    @Enumerated(EnumType.STRING)
    private ArtSourceSize size;
    /**
     * The exact width of the image in pixels, if known. If unknown, omit this field.
     */
    @Column(name = "width_pixels")
    private Long widthPixels;
    /**
     * The exact height of the image in pixels, if known. If unknown, omit this field.
     */
    @Column(name = "height_pixels")
    private Long heightPixels;

    public ArtSource() {
    }

    public ArtSource(String url, ArtSourceSize size, Long widthPixels, Long heightPixels) {
        this.url = url;
        this.size = size;
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
    }
}