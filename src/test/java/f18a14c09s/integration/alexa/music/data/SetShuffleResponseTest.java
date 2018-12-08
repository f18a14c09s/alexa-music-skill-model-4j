package f18a14c09s.integration.alexa.music.data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import f18a14c09s.integration.alexa.data.Response;
import java.util.*;
import java.util.function.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetShuffleResponseTest {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa\",     \"name\": \"Response\",     \"payloadVersion\": \"3.0\"   },   \"payload\": {} }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        GenericResponse subject = (GenericResponse) obj;


        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa");
        assertEquals(subject.getHeader().getName(), "Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "3.0");
    }
}