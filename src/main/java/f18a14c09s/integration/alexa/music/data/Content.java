package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

/**
 * The Content object includes an identifier (reference) and metadata (for example, album name, author name, title, "type", etc.). The Content object can represent a single track, an album, a playlist, a custom station, or a live station. Content objects are global and can be shared between different users. For example, if Content object 1234 is the album "King Animal" by Soundgarden, this is true for any user who receives Content object 1234, and if a user receives Content object 1234 a year later, it should still represent the album "King Animal" by Soundgarden.
 * Note that Content can also be a single song, where the Content ID encodes the audio item ID. This would happen for Search/Find/Browse utterances like "Alexa, show me songs by Fleet Foxes" where the provider would return a Content list where each Content ID points to one Fleet Foxes song.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    /**
     * Globally (in the skill's domain) unique identifier of the Content (e.g. album ID, playlist ID, track ID, etc.). Note that this identifier should uniquely identify some piece of content like an album or a playlist or a track.
     */
    private String id;
    /**
     * An object describing whether the content is playable, browsable, or both. Note that this field should only be present for content returned for display use cases. See the ContentActions object for more details.
     */
    private ContentActions actions;
    /**
     * Metadata for the Content. The value is an instance of MediaMetadata. See the MediaMetadata object for more details.
     */
    private MediaMetadata metadata;
}