package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class ContentActionsTest1 {
    public static final String REFERENCE_TEST_CASE = "{   \"playable\": true,   \"browsable\": false }";
    public static final String MODIFIED_TEST_CASE = "{   \"playable\": true,   \"browsable\": false }";
    // public static final String MODIFIED_TEST_CASE = "{   \"playable\": true,   \"browseable\": false }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ContentActions subject = jsonMapper.readValue(MODIFIED_TEST_CASE, ContentActions.class);
        assertFalse((boolean) subject.getBrowsable());
        // assertFalse((boolean) subject.getBrowseable());
        assertTrue((boolean) subject.getPlayable());
    }
}