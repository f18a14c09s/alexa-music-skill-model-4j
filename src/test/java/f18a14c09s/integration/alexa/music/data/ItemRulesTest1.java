package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 */
public class ItemRulesTest1 {
    public static final String TEST_CASE = "{   \"feedbackEnabled\": false }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ItemRules subject = jsonMapper.readValue(TEST_CASE, ItemRules.class);
        assertFalse((boolean) subject.getFeedbackEnabled());
    }
}