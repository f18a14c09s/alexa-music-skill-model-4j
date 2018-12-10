package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Identifiers to identify a specific Item.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemReference {
    /**
     * The Item identifier.
     */
    private String id;
    /**
     * The ID of the Queue containing the Item.
     */
    private String queueId;
    /**
     * Content identifier that uniquely identifies the content to be played on the device.
     */
    private String contentId;
}