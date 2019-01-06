package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.control.data.QueueControl;
import f18a14c09s.integration.alexa.music.playback.data.PlaybackMethod;
import f18a14c09s.integration.alexa.music.playback.data.PlaybackMethodType;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioPlayerQueue extends PlaybackMethod {
    /**
     * The identifier for this play queue that is opaque to Alexa. If the skill wants to enforce concurrency limits,
     * then the queue ID should be unique for each user. Note that all Music Skill API requests after a queue is created
     * will report this queue ID back to the skill in all requests.
     */
    private String id;

    /**
     * List of QueueControl objects used by Alexa to determine which controls should be clickable in the Alexa app. Note
     * that some queue-level controls might be overridden at the item-level. See the QueueControl object for more
     * information.
     */
    private List<QueueControl> controls;

    /**
     * Identifies rules that apply to all audio items in the play queue. Note that some queue-level rules may be
     * overridden at the item-level.
     */
    private QueueRules rules;

    /**
     * If the skill enforces concurrency limits, it can either reject new Initiate requests with a  DEVICE_LIMIT_REACHED
     * error or it can create a new queue and return a list of existing queue IDs for Alexa to deactivate before
     * initiating playback for the new queue.
     */
    private List<String> queueIdsToDeactivate;

    /**
     * The first item from this queue that Alexa should play for the user. See the Item object for more information.
     */
    private Item firstItem;

    public AudioPlayerQueue() {
        super(PlaybackMethodType.ALEXA_AUDIO_PLAYER_QUEUE);
    }
}
