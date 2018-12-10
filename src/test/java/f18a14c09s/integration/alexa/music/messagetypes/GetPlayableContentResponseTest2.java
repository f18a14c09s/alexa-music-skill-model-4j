package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.ErrorResponseType.CONTENT_NOT_FOUND;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;

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
        Assertions.assertEquals(subject.getPayload().getType(), CONTENT_NOT_FOUND);
        Assertions.assertEquals(subject.getPayload().getMessage(), "Requested content could not be found.");
        Assertions.assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        Assertions.assertEquals(subject.getHeader().getNamespace(), "Alexa.Media");
        Assertions.assertEquals(subject.getHeader().getName(), "ErrorResponse");
        Assertions.assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}