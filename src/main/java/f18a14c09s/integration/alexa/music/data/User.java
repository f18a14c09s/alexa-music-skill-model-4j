package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Describes information about the user who initiated a request to the music skill.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {/**
 * Unique identifier for the user who made the request. Not all music skills will support account linking, and those skills can make use of the user identifier to distinguish API calls triggered by different Alexa users. As an example use case, for skills that do not require account linking, this identifier may be used by the skill to rate limit a specific user. Note: This ID changes every time the user disables and re-enables the skill.
 */
private String id;/**
 * OAuth 2.0 access token from a user's linked account. This property will be set to null if the user has not linked an account with the skill. If this field is present, the skill should use this field to identify the user and should ignore the user identifier provided in this object.
 */
private String accessToken;
}