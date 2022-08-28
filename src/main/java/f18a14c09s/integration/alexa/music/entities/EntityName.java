package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Language;
import f18a14c09s.integration.alexa.data.SpeechInfo;
import f18a14c09s.integration.alexa.data.SpeechType;
import f18a14c09s.integration.alexa.music.data.MetadataNameProperty;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDbBean
@Entity
@Table(name = "entity_names")
public class EntityName {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Language language;
    @Column(name = "\"VALUE\"")
    private String value;

    public EntityName() {
    }

    public EntityName(Language language, String value) {
        this.language = language;
        this.value = value;
    }

    public MetadataNameProperty toMetadataNameProperty() {
        MetadataNameProperty retval = new MetadataNameProperty();
        retval.setDisplay(getValue());
        SpeechInfo speechInfo = new SpeechInfo();
        speechInfo.setText(getValue());
//        speechInfo.setText(getValue() == null ? null : getValue().toLowerCase());
        speechInfo.setType(SpeechType.PLAIN_TEXT);
        retval.setSpeech(speechInfo);
        return retval;
    }
}
