package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.music.data.Feedback.Type.PREFERENCE;
import static f18a14c09s.integration.alexa.music.data.Feedback.Value.POSITIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FeedbackTest1 {
    public static final String TEST_CASE = "{     \"type\": \"PREFERENCE\",     \"value\": \"POSITIVE\" }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Feedback subject = jsonMapper.readValue(TEST_CASE, Feedback.class);
        assertEquals(subject.getType(), PREFERENCE);
        assertEquals(subject.getValue(), POSITIVE);
    }
}