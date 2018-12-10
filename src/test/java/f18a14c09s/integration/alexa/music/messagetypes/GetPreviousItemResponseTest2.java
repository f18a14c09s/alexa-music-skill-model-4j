package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.ErrorResponseType.ITEM_NOT_FOUND;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;

/**
 * When there is no previous item to return, the skill should respond with an ErrorResponse of type ITEM_NOT_FOUND. For example, when the user says "Alexa, previous" while listening to the first track in a queue, the skill sends an error response as in the following example.
 */
public class GetPreviousItemResponseTest2 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio\",     \"name\": \"ErrorResponse\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"type\": \"ITEM_NOT_FOUND\",     \"message\": \"There is no previous item.\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        AudioErrorResponse subject = assertInstanceOfAndCast(obj, AudioErrorResponse.class);
        Assertions.assertEquals(subject.getPayload().getType(), ITEM_NOT_FOUND);
        Assertions.assertEquals(subject.getPayload().getMessage(), "There is no previous item.");
        Assertions.assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        Assertions.assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio");
        Assertions.assertEquals(subject.getHeader().getName(), "ErrorResponse");
        Assertions.assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}