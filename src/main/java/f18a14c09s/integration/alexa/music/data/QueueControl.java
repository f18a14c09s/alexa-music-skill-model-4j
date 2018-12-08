package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ResolvedSelectionCriteria.BasicEntityAttribute.class, visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = AdjustControl.class, name = ControlTypeName.ADJUST),
        @JsonSubTypes.Type(value = CommandControl.class, name = ControlTypeName.COMMAND),
        @JsonSubTypes.Type(value = ToggleControl.class, name = ControlTypeName.TOGGLE)})
public class QueueControl extends BaseControl {
    public QueueControl() {
        this(null);
    }

    protected QueueControl(ControlType type) {
        super(type);
    }
}
