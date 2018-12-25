package f18a14c09s.integration.alexa.music.control.data;

public class AdjustItemControl extends ItemControl {
    protected AdjustItemControl() {
        super(ControlType.ADJUST);
    }

    protected AdjustItemControl(ControlName name, boolean enabled) {
        super(ControlType.ADJUST);
        setName(name);
        setEnabled(enabled);
    }

    public static AdjustItemControl seekPosition(boolean enabled) {
        return new AdjustItemControl(ControlName.SEEK_POSITION, enabled);
    }
}
