package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity {
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
    private Calendar lastUpdatedTime;
    private Boolean deleted;
    private ArrayList<Locale> locales;

    public BaseEntity() {
    }

    public BaseEntity(String id, Calendar lastUpdatedTime, Boolean deleted) {
        this.id = id;
        this.lastUpdatedTime = lastUpdatedTime;
        this.deleted = deleted;
    }
}
