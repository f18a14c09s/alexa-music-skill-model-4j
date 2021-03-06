package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.util.DateUtil.formatAsIso8601UtcSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class StreamTest1 {
    public static final String TEST_CASE =
            "{   \"id\": \"STREAMID_92_14629004\",   \"uri\": \"http://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3\",   \"offsetInMilliseconds\": 0,   \"validUntil\": \"2018-11-10T19:11:35Z\" }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Stream subject = jsonMapper.readValue(TEST_CASE, Stream.class);
        assertEquals(formatAsIso8601UtcSeconds(subject.getValidUntil()), "2018-11-10T19:11:35Z");
        assertEquals(((Number) subject.getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getId(), "STREAMID_92_14629004");
        assertEquals(subject.getUri(), "http://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3");
    }
}