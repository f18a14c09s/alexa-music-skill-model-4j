package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.ErrorResponseType.SKIP_LIMIT_REACHED;
import static f18a14c09s.integration.alexa.music.data.AudioErrorRetryPeriod.DAILY;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * When the skill determines that the user has reached their daily skip limit, it returns an error response indicating the error case as in the following example.
 */
public class GetNextItemResponseTest2 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio\",     \"name\": \"ErrorResponse\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"type\": \"SKIP_LIMIT_REACHED\",     \"message\": \"The user has reached their daily skip limit.\",     \"retryPeriod\": \"DAILY\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        AudioErrorResponse subject = assertInstanceOfAndCast(obj, AudioErrorResponse.class);
        assertEquals(subject.getPayload().getType(), SKIP_LIMIT_REACHED);
        assertEquals(subject.getPayload().getMessage(), "The user has reached their daily skip limit.");
        assertEquals(subject.getPayload().getRetryPeriod(), DAILY);
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio");
        assertEquals(subject.getHeader().getName(), "ErrorResponse");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}