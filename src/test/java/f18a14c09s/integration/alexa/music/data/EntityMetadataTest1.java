package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class EntityMetadataTest1 {
    public static final String TEST_CASE =
            "{   \"name\": {     \"speech\": {       \"type\": \"PLAIN_TEXT\",       \"text\": \"rap god\"     },     \"display\": \"Rap God (Explicit)\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        EntityMetadata subject = jsonMapper.readValue(TEST_CASE, EntityMetadata.class);


        assertEquals(subject.getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(subject.getName().getSpeech().getText(), "rap god");
        assertEquals(subject.getName().getDisplay(), "Rap God (Explicit)");
    }
}