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
public class ContentActionsTest1 {public static final String TEST_CASE = "{   \"playable\": true,   \"browsable\": false }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();ContentActions subject = jsonMapper.readValue(TEST_CASE, ContentActions.class);
assertFalse((boolean)subject.getBrowsable());assertTrue((boolean)subject.getPlayable());
}
}