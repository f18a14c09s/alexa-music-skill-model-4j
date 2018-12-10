package f18a14c09s.integration.alexa.music.control.data;

import java.util.*;

public enum ControlType {
    ADJUST(ControlTypeName.ADJUST),
    COMMAND(ControlTypeName.COMMAND),
    TOGGLE(ControlTypeName.TOGGLE);

    ControlType(String myName) {
        if (!Objects.equals(myName, name())) {
            throw new IllegalArgumentException(String.format(
                    "%s name %s doesn't match %s (value passed into constructor).",
                    getClass().getSimpleName(),
                    name(),
                    myName));
        }
    }
}
