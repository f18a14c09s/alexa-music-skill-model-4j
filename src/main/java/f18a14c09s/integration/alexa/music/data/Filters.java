package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * An object which describes filters that the skill should apply to search results (selection criteria and content) before returning a response to the Alexa service.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filters {/**
 * Determines whether results with explicit language are allowed.
 */
private Boolean explicitLanguageAllowed;
}