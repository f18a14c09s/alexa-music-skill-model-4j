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
public class PlaybackInfoTest1 {public static final String TEST_CASE = "{   \"type\": \"DEFAULT\" }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();PlaybackInfo subject = jsonMapper.readValue(TEST_CASE, PlaybackInfo.class);
assertEquals(subject.getType(), "DEFAULT");
}
}