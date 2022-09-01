package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
public class Popularity {
    @JsonIgnore
    private Long id;
    @JsonProperty("default")
    private Long myDefault;

    @Getter
    @Setter
    private List<PopularityOverride> overrides = Collections.emptyList();

    public Popularity() {
    }

    public Popularity(Long myDefault, ArrayList<PopularityOverride> overrides) {
        this.myDefault = myDefault;
        this.overrides = overrides;
    }

    public Long getDefault() {
        return myDefault;
    }

    public void setDefault(Long myDefault) {
        this.myDefault = myDefault;
    }

    public static Popularity unratedWithNoOverrides() {
        return new Popularity(0L, null);
    }
}
