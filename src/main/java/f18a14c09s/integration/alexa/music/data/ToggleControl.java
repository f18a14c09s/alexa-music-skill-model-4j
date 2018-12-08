package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToggleControl extends QueueControl {
    private Boolean selected;

    protected ToggleControl() {
        super(ControlType.TOGGLE);
    }
}
