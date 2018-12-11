package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
    private ZonedDateTime lastUpdatedTime;
    private Boolean deleted;
    private ArrayList<Locale> locales;

    public BaseEntity() {
    }

    public BaseEntity(String id, ZonedDateTime lastUpdatedTime, Boolean deleted) {
        this.id = id;
        this.lastUpdatedTime = lastUpdatedTime;
        this.deleted = deleted;
    }
}
