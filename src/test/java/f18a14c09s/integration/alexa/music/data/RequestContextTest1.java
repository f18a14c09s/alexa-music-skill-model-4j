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
public class RequestContextTest1 {
    public static final String TEST_CASE =
            "{   \"user\": {     \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",     \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"   },   \"location\": {     \"originatingLocale\": \"en-US\",     \"countryCode\": \"US\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        RequestContext subject = jsonMapper.readValue(TEST_CASE, RequestContext.class);

        assertEquals(subject.getLocation().getOriginatingLocale(), "en-US");
        assertEquals(subject.getLocation().getCountryCode(), "US");
        assertEquals(subject.getUser().getId(), "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getUser().getAccessToken(), "e72e16c7e42f292c6912e7710c838347ae178b4a");
    }
}