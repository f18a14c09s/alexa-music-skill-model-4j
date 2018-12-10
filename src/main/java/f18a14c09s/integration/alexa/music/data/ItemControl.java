package f18a14c09s.integration.alexa.music.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

/**
 * An object that describes a control that the user can take on an item. Examples are skip forward and skip backward buttons. Note that item controls will override any existing queue controls of the same type.
 */
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ResolvedSelectionCriteria.BasicEntityAttribute.class, visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = AdjustItemControl.class, name = ControlTypeName.ADJUST),
        @JsonSubTypes.Type(value = CommandItemControl.class, name = ControlTypeName.COMMAND)})
public abstract class ItemControl extends BaseControl {
    protected ItemControl(ControlType type) {
        super(type);
    }
}