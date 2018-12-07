package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.data.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SetLoopResponseTest {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa\",     \"name\": \"Response\",     \"payloadVersion\": \"3.0\"   },   \"payload\": {} }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        SetLoopResponse subject = (SetLoopResponse) obj;


        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa");
        assertEquals(subject.getHeader().getName(), "Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "3.0");
    }
}