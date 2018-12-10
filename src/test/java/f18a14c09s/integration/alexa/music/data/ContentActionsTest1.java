package f18a14c09s.integration.alexa.music.data;import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ContentActionsTest1 {
    public static final String REFERENCE_TEST_CASE = "{   \"playable\": true,   \"browsable\": false }";
    public static final String MODIFIED_TEST_CASE = "{   \"playable\": true,   \"browseable\": false }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ContentActions subject = jsonMapper.readValue(MODIFIED_TEST_CASE, ContentActions.class);
        assertFalse((boolean) subject.getBrowseable());
        assertTrue((boolean) subject.getPlayable());
    }
}