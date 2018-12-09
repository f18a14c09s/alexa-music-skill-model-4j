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
public class BaseControlTest1 {public static final String TEST_CASE = "{   \"type\": \"COMMAND\",   \"name\": \"NEXT\",   \"enabled\": true }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();BaseControl subject = jsonMapper.readValue(TEST_CASE, BaseControl.class);
assertEquals(subject.getName(), "NEXT");assertEquals(subject.getType(), "COMMAND");assertTrue((boolean)subject.getEnabled());
}
}