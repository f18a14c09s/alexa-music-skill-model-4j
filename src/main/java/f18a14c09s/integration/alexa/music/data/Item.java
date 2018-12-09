package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * An (audio) item that contains within it an identifier and metadata (for example, art URLs, author name, title, etc.), and a Stream containing the playback URL. Note that in some cases, the duration of an item needs to be displayed when there is no stream for that item. That is why the duration field is a peer to the stream field and not a member of it.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {/**
 * A identifier for the item that is opaque to Alexa. Note that the item should be unique within the queue.
 */
private String id;/**
 * Describes which business rules Alexa should run when playing or displaying this item. See the PlaybackInfo object for details.
 */
private String playbackInfo;/**
 * Metadata for the item. For playbackInfo types DEFAULT and SAMPLE, the value will be an instance of MediaMetadata, where the metadata type field can either be TRACK or STATION. See the MediaMetadata object for details. For playbackInfo type AD, the value will be an instance of AdMetadata. See the AdMetadata object for details.
 */
private AdMetadata metadata;/**
 * Duration of the item in milliseconds. If the item is a live stream, do not return this field.
 */
private Long durationInMilliseconds;/**
 * List of ItemControl objects used by Alexa to determine which controls should be clickable in the Alexa app.
 */
private ArrayList controls;/**
 * Object which contains rules for the item. See ItemRules for details.
 */
private ItemRules rules;/**
 * Object that contains stream information for this item. See the Stream object for more information.
 */
private Stream stream;/**
 * Rating of the item if it exists. For example, if the user had previously indicated "thumbs down" for this item, the skill should set feedback type to PREFERENCE and the feedback value to to NEGATIVE. See the Feedback object for more information.
 */
private Feedback feedback;
}