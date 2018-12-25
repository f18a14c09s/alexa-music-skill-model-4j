package f18a14c09s.integration.alexa.music.control.data;

public class CommandItemControl extends ItemControl {
    protected CommandItemControl() {
        super(ControlType.COMMAND);
    }

    protected CommandItemControl(ControlName name, boolean enabled) {
        super(ControlType.COMMAND);
        setName(name);
        setEnabled(enabled);
    }

    public static CommandItemControl previous(boolean enabled) {
        return new CommandItemControl(ControlName.PREVIOUS, enabled);
    }

    public static CommandItemControl next(boolean enabled) {
        return new CommandItemControl(ControlName.NEXT, enabled);
    }
}
