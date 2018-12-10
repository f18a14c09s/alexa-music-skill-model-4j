package f18a14c09s.integration.alexa.music.data;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import static f18a14c09s.integration.alexa.music.data.ControlName.SEEK_POSITION;
import static f18a14c09s.integration.alexa.music.data.ControlType.ADJUST;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class QueueControlTest1 {
    public static final String TEST_CASE =
            "{   \"type\": \"ADJUST\",   \"name\": \"SEEK_POSITION\",   \"enabled\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        QueueControl subject = jsonMapper.readValue(TEST_CASE, QueueControl.class);
        assertEquals(subject.getName(), SEEK_POSITION);
        assertEquals(subject.getType(), ADJUST);
        assertTrue((boolean) subject.getEnabled());
    }
}