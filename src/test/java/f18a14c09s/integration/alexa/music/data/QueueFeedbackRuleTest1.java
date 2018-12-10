package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class QueueFeedbackRuleTest1 {
    public static final String TEST_CASE = "{   \"type\": \"PREFERENCE\",   \"enabled\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        QueueFeedbackRule subject = jsonMapper.readValue(TEST_CASE, QueueFeedbackRule.class);
        assertEquals(subject.getType(), "PREFERENCE");
        assertTrue((boolean) subject.getEnabled());
    }
}