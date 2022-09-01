package f18a14c09s.integration.alexa.smapi.data;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CatalogCreationRequest {
    private String title;
    private String type;
    private String usage;
    private String vendorId;
}