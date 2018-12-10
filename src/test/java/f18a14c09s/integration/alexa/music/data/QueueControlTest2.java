package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.music.data.ControlName.LOOP;
import static f18a14c09s.integration.alexa.music.data.ControlType.TOGGLE;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class QueueControlTest2 {
    public static final String TEST_CASE =
            "{   \"type\": \"TOGGLE\",   \"name\": \"LOOP\",   \"enabled\": true,   \"selected\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        QueueControl obj = jsonMapper.readValue(TEST_CASE, QueueControl.class);
        ToggleQueueControl subject = assertInstanceOfAndCast(obj, ToggleQueueControl.class);
        assertEquals(subject.getName(), LOOP);
        assertEquals(subject.getType(), TOGGLE);
        assertTrue((boolean) subject.getEnabled());
        assertTrue((boolean) subject.getSelected());
    }
}