package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * Contains fields necessary for describing the context of an Alexa Music Skill API request.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestContext {/**
 * Contains user-specific information from the request. See the User object for more information.
 */
private User user;/**
 * Object that describes a request's location. See the Location object for more information.
 */
private Location location;
}