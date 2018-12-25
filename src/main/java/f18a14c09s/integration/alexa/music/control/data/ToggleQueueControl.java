package f18a14c09s.integration.alexa.music.control.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToggleQueueControl extends QueueControl {
    private Boolean selected;

    public ToggleQueueControl() {
        this(null, null, null);
    }

    public ToggleQueueControl(ControlName name, Boolean enabled, Boolean selected) {
        super(ControlType.TOGGLE);
        setName(name);
        setEnabled(enabled);
        setSelected(selected);
    }

    public static ToggleQueueControl shuffle(boolean enabled, boolean selected) {
        return new ToggleQueueControl(ControlName.SHUFFLE, enabled, selected);
    }

    public static ToggleQueueControl loop(boolean enabled, boolean selected) {
        return new ToggleQueueControl(ControlName.LOOP, enabled, selected);
    }
}
