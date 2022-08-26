package f18a14c09s.integration.alexa.smapi.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class Catalog {
    private String id;
    private String title;
    private String type;
    private String usage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Calendar createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Calendar lastUpdatedDate;
    private List<String> associatedSkillIds;
}
