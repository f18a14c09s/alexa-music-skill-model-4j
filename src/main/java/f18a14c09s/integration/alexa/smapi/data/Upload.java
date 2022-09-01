package f18a14c09s.integration.alexa.smapi.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class Upload {
    @Getter
    @Setter
    public static final class UploadFile {
        private String presignedDownloadUrl;
        private String status;
    }

    @Getter
    @Setter
    public static final class IngestionError {
        private String code;
        private String message;
    }

    @Getter
    @Setter
    public static final class IngestionStep {
        private String name;
        private String status;
        private String logUrl;
        private List<IngestionError> errors;
    }

    private String id;
    private String catalogId;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Calendar createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Calendar lastUpdatedDate;
    private UploadFile file;
    private List<IngestionStep> ingestionSteps;
}
