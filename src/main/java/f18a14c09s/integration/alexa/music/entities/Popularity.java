package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Popularity {
    @JsonProperty("default")
    private Long myDefault;

    @Getter
    @Setter
    private ArrayList<PopularityOverride> overrides;

    public Long getDefault() {
        return myDefault;
    }

    public void setDefault(Long myDefault) {
        this.myDefault = myDefault;
    }
}
