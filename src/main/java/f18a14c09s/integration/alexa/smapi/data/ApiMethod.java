package f18a14c09s.integration.alexa.smapi.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiMethod {
    LIST_CATALOGS(
            "GET",
            "/v0/catalogs"
    ),
    CREATE_CATALOG(
            "POST",
            "/v0/catalogs"
    ),
    ASSOCIATE_CATALOG_WITH_SKILL(
            "PUT",
            "/v0/skills/{skillId}/catalogs/{catalogId}"
    ),
    CREATE_UPLOAD(
            "POST",
            "/v0/catalogs/{catalogId}/uploads"
    ),
    COMPLETE_UPLOAD(
            "POST",
            "/v0/catalogs/{catalogId}/uploads/{uploadId}"
    ),
    LIST_UPLOADS(
            "GET",
            "/v0/catalogs/{catalogId}/uploads"
    ),
    GET_UPLOAD(
            "GET",
            "/v0/catalogs/{catalogId}/uploads/{uploadId}"
    );
    private final String method;
    private final String path;
}