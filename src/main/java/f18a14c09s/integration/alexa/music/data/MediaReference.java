package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * A polymorphic object used to identify a specific media item (Item) to be used in cases where a media item must be identified in a domain-agnostic manner.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaReference<Value> {
    /**
     * Identifies the interface of the property object. In the case of music skills, the namespace will be Alexa.Audio.PlayQueue. The value of this field identifies the possible types for the name and value fields in this object.
     */
    private String namespace;
    /**
     * The name of the content being consumed by the Alexa user. The possible set of values for this field are determined by the value of the namespace field. In the case of music skills, this field's value is always item.
     */
    private Object name;
    /**
     * Identifies a specific piece of content. For the Alexa.Audio.PlayQueue namespace, and item name, the value property must contain an ItemReference object. See the following example.
     */
    private Value value;
}