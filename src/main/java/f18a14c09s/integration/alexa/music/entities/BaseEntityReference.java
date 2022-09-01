package f18a14c09s.integration.alexa.music.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public abstract class BaseEntityReference {
    private String id;

    private List<EntityName> names = Collections.emptyList();

    private List<AlternateNames> alternateNames;
}
