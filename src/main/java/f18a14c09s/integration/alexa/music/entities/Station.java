package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = RelationalTableName.STATION)
@DiscriminatorValue(EntityTypeName.STATION)
public class Station extends BaseEntity {
    @Column(name = "channel_id")
    private Long channelId;
    @Column(name = "call_sign")
    private String callSign;
    private String frequency;
    @Column(name = "owned_and_operated")
    private String ownedAndOperated;

    @ElementCollection
    @CollectionTable(name = "station_languages", joinColumns = {
            @JoinColumn(name = "station_id", referencedColumnName = "id")})
    private List<String> languageOfContent;
}
