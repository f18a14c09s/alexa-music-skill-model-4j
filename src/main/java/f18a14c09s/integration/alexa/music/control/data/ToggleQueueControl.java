package f18a14c09s.integration.alexa.music.control.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToggleQueueControl extends QueueControl {
    private Boolean selected;

    public ToggleQueueControl() {
        super(ControlType.TOGGLE);
    }
}
