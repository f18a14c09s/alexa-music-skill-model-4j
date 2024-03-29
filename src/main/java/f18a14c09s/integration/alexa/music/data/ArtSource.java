package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * Contains information about a single size of a media content's art (for example, album cover art).
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
public class ArtSource {
    @JsonIgnore
    private Long id;
    /**
     * The URL for the image of this size. URL must be HTTPS.
     */
    private String url;
    /**
     * The size for the image. Alexa can use this optional field to help determine which size of ArtSource to use. If the skill knows the exact image dimensions and populates widthPixels or heightPixels, the skill should also populate this field to the appropriate size based on those values. However, this field can be populated without having to specify widthPixels or heightPixels if unknown. If an image size is unknown then this field can be left blank. Valid values and recommended image sizes for each: "X_SMALL" (recommended for images approximately 48 x 48 pixels) "SMALL" (recommended for 60 x 60 pixels) "MEDIUM" (recommended for 110 x 110 pixels) "LARGE" (recommended for 256 x 256 pixels) "X_LARGE" (recommended for 600 x 600 pixels)
     */
    private ArtSourceSize size;
    /**
     * The exact width of the image in pixels, if known. If unknown, omit this field.
     */
    private Long widthPixels;
    /**
     * The exact height of the image in pixels, if known. If unknown, omit this field.
     */
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