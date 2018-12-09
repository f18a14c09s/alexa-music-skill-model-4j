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
public class SpeechInfoTest1 {
    public static final String TEST_CASE = "{   \"type\": \"PLAIN_TEXT\",   \"text\": \"lady gaga\" }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        SpeechInfo subject = jsonMapper.readValue(TEST_CASE, SpeechInfo.class);
//        assertEquals(subject.getText(), "lady gaga");
//        assertEquals(subject.getType(), "PLAIN_TEXT");
    }
}