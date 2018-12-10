package f18a14c09s.integration.alexa.music.control.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import f18a14c09s.integration.alexa.music.data.ResolvedSelectionCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ResolvedSelectionCriteria.BasicEntityAttribute.class, visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = AdjustQueueControl.class, name = ControlTypeName.ADJUST),
        @JsonSubTypes.Type(value = CommandQueueControl.class, name = ControlTypeName.COMMAND),
        @JsonSubTypes.Type(value = ToggleQueueControl.class, name = ControlTypeName.TOGGLE)})
public abstract class QueueControl extends BaseControl {
    protected QueueControl(ControlType type) {
        super(type);
    }
}
