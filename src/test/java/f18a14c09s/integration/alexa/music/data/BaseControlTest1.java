package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.music.control.data.CommandItemControl;
import f18a14c09s.integration.alexa.music.control.data.ItemControl;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.music.control.data.ControlName.NEXT;
import static f18a14c09s.integration.alexa.music.control.data.ControlType.COMMAND;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class BaseControlTest1 {
    public static final String TEST_CASE = "{   \"type\": \"COMMAND\",   \"name\": \"NEXT\",   \"enabled\": true }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ItemControl obj = jsonMapper.readValue(TEST_CASE, ItemControl.class);
        CommandItemControl subject = assertInstanceOfAndCast(obj, CommandItemControl.class);
        assertEquals(subject.getName(), NEXT);
        assertEquals(subject.getType(), COMMAND);
        assertTrue((boolean) subject.getEnabled());
    }
}