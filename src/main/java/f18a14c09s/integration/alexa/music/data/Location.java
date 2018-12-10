package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Describes the location of a request. Use this information to enforce geographical restrictions on content or decide which language version of metadata to return to Alexa for media items.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    /**
     * The locale for the user. This is the locale that the user specified based on the language setting on the device. Locale is formatted as specified for languages in BCP-47. When the locale is not required for the skill to process a request, this field may be absent.
     */
    private String originatingLocale;
    /**
     * Code (based on ISO 3166-1 alpha-2) for the country where the request was made. This might be the country of the registered account of the user who made the request, or the country of the target device owned by that user.
     */
    private String countryCode;
}