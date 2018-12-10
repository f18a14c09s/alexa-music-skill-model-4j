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
public class ItemRulesTest1 {public static final String TEST_CASE = "{   \"feedbackEnabled\": false }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();ItemRules subject = jsonMapper.readValue(TEST_CASE, ItemRules.class);
assertFalse((boolean)subject.getFeedbackEnabled());
}
}