package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * An object describing whether a Content is playable, browsable, or both.
 * The flags in this object are intended to support display use cases where the user can click a Content object to play all its contents (for example, play an entire album) or the user can click a Content object to view the items within (for example, see the tracks listing for the album) and perhaps play one item.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentActions {/**
 * Determines whether the content is playable. Defaults to true.
 */
private Boolean playable;/**
 * Determines whether the content is browsable.
 */
private Boolean browseable;
}