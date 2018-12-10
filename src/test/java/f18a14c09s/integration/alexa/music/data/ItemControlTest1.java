package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.music.data.ControlName.NEXT;
import static f18a14c09s.integration.alexa.music.data.ControlType.COMMAND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class ItemControlTest1 {
    public static final String TEST_CASE = "{   \"type\": \"COMMAND\",   \"name\": \"NEXT\",   \"enabled\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ItemControl subject = jsonMapper.readValue(TEST_CASE, ItemControl.class);
        assertEquals(subject.getName(), NEXT);
        assertEquals(subject.getType(), COMMAND);
        assertTrue((boolean) subject.getEnabled());
    }
}