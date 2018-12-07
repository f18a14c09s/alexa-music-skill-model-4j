package f18a14c09s.integration.alexa.music.data;

import f18a14c09s.integration.alexa.data.MetadataNameProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseMetadata<Type extends Enum<Type>> {
    private Type type;
    private MetadataNameProperty name;
    private Art art;
}
