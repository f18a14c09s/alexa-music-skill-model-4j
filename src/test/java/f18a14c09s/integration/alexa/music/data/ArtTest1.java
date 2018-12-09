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
public class ArtTest1 {public static final String TEST_CASE = "{   \"contentDescription\": \"A close-up picture of the artist Lady Gaga.\",   \"sources\": [     {       \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",       \"size\": \"X_SMALL\",       \"widthPixels\": 48,       \"heightPixels\": 48     },     {       \"url\": \"https://example.com/images/cover/60x60-000000-80-0-0.jpg\",       \"size\": \"SMALL\",       \"widthPixels\": 60,       \"heightPixels\": 60     },     {       \"url\": \"https://example.com/images/cover/110x110-000000-80-0-0.jpg\",       \"size\": \"MEDIUM\",       \"widthPixels\": 110,       \"heightPixels\": 110     },     {       \"url\": \"https://example.com/images/cover/256x256-000000-80-0-0.jpg\",       \"size\": \"LARGE\",       \"widthPixels\": 256,       \"heightPixels\": 256     },     {       \"url\": \"https://example.com/images/cover/600x600-000000-80-0-0.jpg\",       \"size\": \"X_LARGE\",       \"widthPixels\": 600,       \"heightPixels\": 600     }   ] }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();Art subject = jsonMapper.readValue(TEST_CASE, Art.class);

assertEquals(subject.getSources().get(0).getUrl(), "https://example.com/images/cover/48x48-000000-80-0-0.jpg");assertEquals(subject.getSources().get(0).getSize(), "X_SMALL");assertEquals(((Number)subject.getSources().get(0).getWidthPixels()).longValue(), 48L);assertEquals(((Number)subject.getSources().get(0).getHeightPixels()).longValue(), 48L);
assertEquals(subject.getSources().get(1).getUrl(), "https://example.com/images/cover/60x60-000000-80-0-0.jpg");assertEquals(subject.getSources().get(1).getSize(), "SMALL");assertEquals(((Number)subject.getSources().get(1).getWidthPixels()).longValue(), 60L);assertEquals(((Number)subject.getSources().get(1).getHeightPixels()).longValue(), 60L);
assertEquals(subject.getSources().get(2).getUrl(), "https://example.com/images/cover/110x110-000000-80-0-0.jpg");assertEquals(subject.getSources().get(2).getSize(), "MEDIUM");assertEquals(((Number)subject.getSources().get(2).getWidthPixels()).longValue(), 110L);assertEquals(((Number)subject.getSources().get(2).getHeightPixels()).longValue(), 110L);
assertEquals(subject.getSources().get(3).getUrl(), "https://example.com/images/cover/256x256-000000-80-0-0.jpg");assertEquals(subject.getSources().get(3).getSize(), "LARGE");assertEquals(((Number)subject.getSources().get(3).getWidthPixels()).longValue(), 256L);assertEquals(((Number)subject.getSources().get(3).getHeightPixels()).longValue(), 256L);
assertEquals(subject.getSources().get(4).getUrl(), "https://example.com/images/cover/600x600-000000-80-0-0.jpg");assertEquals(subject.getSources().get(4).getSize(), "X_LARGE");assertEquals(((Number)subject.getSources().get(4).getWidthPixels()).longValue(), 600L);assertEquals(((Number)subject.getSources().get(4).getHeightPixels()).longValue(), 600L);assertEquals(subject.getContentDescription(), "A close-up picture of the artist Lady Gaga.");
}
}