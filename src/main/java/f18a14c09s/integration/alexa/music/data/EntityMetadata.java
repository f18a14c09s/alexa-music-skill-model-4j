package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * Metadata for entities like artists, songs, etc.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityMetadata {/**
 * Name of the entity to be used in Alexa voice prompts or for display use cases. See the MetadataNameProperty object for details.
 */
private String name;
}