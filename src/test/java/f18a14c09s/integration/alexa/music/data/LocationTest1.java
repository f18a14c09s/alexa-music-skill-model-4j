package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class LocationTest1 {
    public static final String TEST_CASE = "{   \"originatingLocale\": \"en-US\",   \"countryCode\": \"US\" }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Location subject = jsonMapper.readValue(TEST_CASE, Location.class);
        assertEquals(subject.getCountryCode(), "US");
        assertEquals(subject.getOriginatingLocale(), "en-US");
    }
}