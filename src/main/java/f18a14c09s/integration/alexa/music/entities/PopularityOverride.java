package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
public class PopularityOverride {
    @JsonIgnore
    private Long id;
    private Locale locale;
    private Long value;
}
