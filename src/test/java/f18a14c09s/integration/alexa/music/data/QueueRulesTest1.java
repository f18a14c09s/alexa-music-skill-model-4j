package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.music.data.Feedback.Type.PREFERENCE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class QueueRulesTest1 {
    public static final String TEST_CASE =
            "{   \"feedback\": {     \"type\": \"PREFERENCE\",     \"enabled\": true   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        QueueRules subject = jsonMapper.readValue(TEST_CASE, QueueRules.class);

        assertEquals(subject.getFeedback().getType(), PREFERENCE);
        assertTrue((boolean) subject.getFeedback().getEnabled());
    }
}