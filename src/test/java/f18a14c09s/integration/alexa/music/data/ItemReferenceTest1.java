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
public class ItemReferenceTest1 {public static final String TEST_CASE = "{   \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",   \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",   \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\" }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();ItemReference subject = jsonMapper.readValue(TEST_CASE, ItemReference.class);
assertEquals(subject.getQueueId(), "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");assertEquals(subject.getContentId(), "1021012f-12bb-4938-9723-067a4338b6d0");assertEquals(subject.getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
}
}