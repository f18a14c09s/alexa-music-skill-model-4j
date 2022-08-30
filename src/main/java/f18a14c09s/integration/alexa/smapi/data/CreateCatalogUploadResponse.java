package f18a14c09s.integration.alexa.smapi.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class CreateCatalogUploadResponse {
    @Getter
    @Setter
    public static final class PresignedUploadPart {
        private String url;
        private Long partNumber;
    }

    private String id;
    private String catalogId;
    private String status;
    private List<String> locales;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime lastUpdatedDate;
    private List<Upload.IngestionStep> ingestionSteps;
    private List<PresignedUploadPart> presignedUploadParts;
}
