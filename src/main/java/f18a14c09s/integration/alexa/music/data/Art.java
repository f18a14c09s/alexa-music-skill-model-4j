package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * Contains artwork for a media content.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Art {/**
 * Description of the art for accessibility purposes. Optional but recommended.
 */
private String contentDescription;/**
 * List of ArtSource objects each describing one size of the art. See the ArtSource object for more information.
 */
private ArrayList sources;
}