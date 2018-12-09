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
public class QueueRulesTest1 {public static final String TEST_CASE = "{   \"feedback\": {     \"type\": \"PREFERENCE\",     \"enabled\": true   } }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();QueueRules subject = jsonMapper.readValue(TEST_CASE, QueueRules.class);

assertEquals(subject.getFeedback().getType(), "PREFERENCE");assertTrue((boolean)subject.getFeedback().getEnabled());
}
}