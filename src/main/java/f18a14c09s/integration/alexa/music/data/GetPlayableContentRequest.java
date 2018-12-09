package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import f18a14c09s.integration.alexa.data.Request;/**
 * When a user requests content from your skill, Alexa sends a GetPlayableContent request to your skill. For example, if a user says "Alexa, play Alive from the album Ten on skill name", the skill receives a GetPlayableContent request that contains information about the user and the requested content. The skill can respond with a content identifier that represents the song Alive from the album Ten. If the skill cannot satisfy the request—for example, the user's subscription tier does not support the content, or geographic streaming rights do not allow streaming to the user's location—the skill can respond with the appropriate error code.
 * The response does not initiate playback of audio on the device, it only indicates whether the skill has audio content that satisfies the request. If the Alexa service determines that the audio content should be played, a subsequent request is made.
 */
@JsonDeserialize
public class GetPlayableContentRequest extends Request<GetPlayableContentRequest.Payload> {
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public static final class Payload {/**
 * An object containing context information about the request. See the RequestContext object for more information.
 */
private RequestContext requestContext;/**
 * Filters to apply during content resolution. See the Filters object for more information.
 */
private Filters filters;/**
 * The ResolvedSelectionCriteria that should be resolved to a Content to play for the user. See the ResolvedSelectionCriteria object for more information.
 */
private ResolvedSelectionCriteria selectionCriteria;
}
}