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
public class ArtSourceTest1 {public static final String TEST_CASE = "{   \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",   \"size\": \"X_SMALL\",   \"widthPixels\": 48,   \"heightPixels\": 48 }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();ArtSource subject = jsonMapper.readValue(TEST_CASE, ArtSource.class);
assertEquals(subject.getSize(), "X_SMALL");assertEquals(((Number)subject.getHeightPixels()).longValue(), 48L);assertEquals(subject.getUrl(), "https://example.com/images/cover/48x48-000000-80-0-0.jpg");assertEquals(((Number)subject.getWidthPixels()).longValue(), 48L);
}
}