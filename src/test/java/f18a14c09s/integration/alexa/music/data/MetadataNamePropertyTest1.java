package f18a14c09s.integration.alexa.music.data;import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * 
 */
public class MetadataNamePropertyTest1 {public static final String TEST_CASE = "{   \"speech\": {     \"type\": \"PLAIN_TEXT\",     \"text\": \"thrift shop\"   },   \"display\": \"Thrift Shop\" }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();MetadataNameProperty subject = jsonMapper.readValue(TEST_CASE, MetadataNameProperty.class);

assertEquals(subject.getSpeech().getType(), PLAIN_TEXT);assertEquals(subject.getSpeech().getText(), "thrift shop");assertEquals(subject.getDisplay(), "Thrift Shop");
}
}