package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * An object describing whether a Content is playable, browsable, or both.
 * The flags in this object are intended to support display use cases where the user can click a Content object to play all its contents (for example, play an entire album) or the user can click a Content object to view the items within (for example, see the tracks listing for the album) and perhaps play one item.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentActions {
    /**
     * Determines whether the content is playable. Defaults to true.
     */
    private Boolean playable;
    /**
     * Determines whether the content is browsable.
     */
    private Boolean browsable;
    // private Boolean browseable;

    public static ContentActions browseable() {
        ContentActions retval = new ContentActions();
        retval.setBrowsable(true);
        // retval.setBrowseable(true);
        return retval;
    }

    public static ContentActions playable() {
        ContentActions retval = new ContentActions();
        retval.setPlayable(true);
        return retval;
    }

    public static ContentActions browseableAndPlayable() {
        ContentActions retval = new ContentActions();
        retval.setBrowsable(true);
        // retval.setBrowseable(true);
        retval.setPlayable(true);
        return retval;
    }
}