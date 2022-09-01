package f18a14c09s.integration.alexa.smapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
public class CatalogListing {
    @JsonProperty("_links")
    private Map<String, Object> links;
    @JsonProperty("isTruncated")
    private Boolean truncated;
    private String nextToken;
    private List<Catalog> catalogs;
}
