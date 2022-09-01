package f18a14c09s.integration.alexa.music.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.data.Locale;
import f18a14c09s.integration.alexa.music.metadata.MediaMetadata;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseEntity {
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
    private ZonedDateTime lastUpdatedTime;

    private Boolean deleted;

    private List<Locale> locales;

    private List<EntityName> names = Collections.emptyList();

    private List<AlternateNames> alternateNames;

    private Popularity popularity;

    public BaseEntity() {
    }

    public BaseEntity(String id,
                      ZonedDateTime lastUpdatedTime,
                      Boolean deleted,
                      List<Locale> locales,
                      List<EntityName> names,
                      List<AlternateNames> alternateNames,
                      Popularity popularity) {
        this.id = id;
        this.lastUpdatedTime = lastUpdatedTime;
        this.deleted = deleted;
        this.locales = locales;
        this.names = names;
        this.alternateNames = alternateNames;
        this.popularity = popularity;
    }

    public MediaMetadata toMediaMetadata() {
        return null;
    }
}
