package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class UserTest1 {
    public static final String TEST_CASE =
            "{   \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",   \"accessToken\": \"e70e10c7e02f092c6002e1234c54321ab192b4c\" }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        User subject = jsonMapper.readValue(TEST_CASE, User.class);
        assertEquals(subject.getId(), "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getAccessToken(), "e70e10c7e02f092c6002e1234c54321ab192b4c");
    }
}