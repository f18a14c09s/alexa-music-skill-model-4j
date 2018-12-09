package f18a14c09s.integration.alexa.music.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;/**
 * An object that describes a control that the user can take on an item. Examples are skip forward and skip backward buttons. Note that item controls will override any existing queue controls of the same type.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemControl {
}