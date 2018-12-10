package f18a14c09s.integration.alexa.music.messaging.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * When the currently playing item is the last item in the queue, the skill returns a response indicating that there are no more tracks to return.
 */
public class GetNextItemResponseTest3 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetNextItem.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"isQueueFinished\": true   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        GetNextItemResponse subject = assertInstanceOfAndCast(obj, GetNextItemResponse.class);
        assertTrue((boolean) subject.getPayload().getIsQueueFinished());
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetNextItem.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}