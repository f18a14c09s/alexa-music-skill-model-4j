package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class FiltersTest1 {
    public static final String TEST_CASE = "{   \"explicitLanguageAllowed\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Filters subject = jsonMapper.readValue(TEST_CASE, Filters.class);
        assertTrue((boolean) subject.getExplicitLanguageAllowed());
    }
}