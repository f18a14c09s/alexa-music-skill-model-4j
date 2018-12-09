package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class QueueControlTest2 {
    public static final String TEST_CASE =
            "{   \"type\": \"TOGGLE\",   \"name\": \"LOOP\",   \"enabled\": true,   \"selected\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        QueueControl object = jsonMapper.readValue(TEST_CASE, QueueControl.class);
        ToggleControl subject=(ToggleControl)object;
        assertEquals(subject.getName(), "LOOP");
        assertEquals(subject.getType(), "TOGGLE");
        assertTrue((boolean) subject.getEnabled());
        assertTrue((boolean) subject.getSelected());
    }
}