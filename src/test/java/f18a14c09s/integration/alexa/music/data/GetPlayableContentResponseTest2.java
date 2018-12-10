package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.ErrorResponseType.CONTENT_NOT_FOUND;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * In the following example, the skill cannot find playable content to satisfy the user's request so it returns an error response.
 */
public class GetPlayableContentResponseTest2 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media\",     \"name\": \"ErrorResponse\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"type\": \"CONTENT_NOT_FOUND\",     \"message\": \"Requested content could not be found.\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        MediaErrorResponse subject = assertInstanceOfAndCast(obj, MediaErrorResponse.class);
        assertEquals(subject.getPayload().getType(), CONTENT_NOT_FOUND);
        assertEquals(subject.getPayload().getMessage(), "Requested content could not be found.");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media");
        assertEquals(subject.getHeader().getName(), "ErrorResponse");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}