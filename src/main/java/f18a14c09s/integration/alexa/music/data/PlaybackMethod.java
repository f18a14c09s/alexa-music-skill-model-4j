package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * When Alexa has a reference to some content as a result of GetPlayableContent, and wants to start playback for the user, it invokes the skill with the content reference so the skill can realize the content into a PlaybackMethod. So, PlaybackMethod is a realization of Content.
 * It is up to the skill to determine whether a queue can be reused between users or streaming sessions. For example, to support concurrency limit use cases, a queue might have to be unique for each user or streaming session. As another example, music cast from an app to an Alexa device should likely share the same queue from which the app was playing before casting. It is important to note that you can optimize play queue creation by sharing the same queue between different users without storing any information for each user or device. This is possible because in the Queue interfaces, Alexa includes the item ID, queue ID, and content reference in each request. Therefore, you don't need to store progress state for each user within a certain play queue.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaybackMethod {/**
 * The type of the playback method. The only allowed value is ALEXA_AUDIO_PLAYER_QUEUE.
 */
private String type;
}