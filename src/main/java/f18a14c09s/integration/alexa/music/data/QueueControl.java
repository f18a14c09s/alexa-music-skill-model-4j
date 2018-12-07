package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueueControl extends BaseControl {
    protected QueueControl(ControlType type) {
        super(type);
    }
}
