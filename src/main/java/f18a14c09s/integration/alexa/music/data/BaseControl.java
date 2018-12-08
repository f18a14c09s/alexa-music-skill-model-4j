package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseControl {
    private ControlType type;
    private ControlName name;
    private Boolean enabled;

    protected BaseControl(ControlType type) {
        this.type = type;
    }

    protected BaseControl(ControlType type, ControlName name, Boolean enabled, ControlType... validTypes) {
        this(type);
        this.name = name;
        this.enabled = enabled;
    }
}
