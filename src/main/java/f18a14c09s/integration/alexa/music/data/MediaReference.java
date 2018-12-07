package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaReference<Name, Value> {
    private String namespace;
    private Name name;
    private Value value;
}
