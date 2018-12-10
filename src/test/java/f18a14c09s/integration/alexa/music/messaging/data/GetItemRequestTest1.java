package f18a14c09s.integration.alexa.music.messaging.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Imagine the following scenario: Alexa is playing the first song from a skill's Initiate response. The user pauses playback, then one hour later says "Alexa, resume". The stream URI is now expired, so Alexa will send a GetItem request to obtain a new, non-expired stream URI. See the following example.
 */
public class GetItemRequestTest1 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.PlayQueue\",     \"name\": \"GetItem\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c691234567c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"targetItemReference\": {       \"namespace\": \"Alexa.Audio.PlayQueue\",       \"name\": \"item\",       \"value\": {         \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",         \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",         \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\"       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Request obj = jsonMapper.readValue(TEST_CASE, Request.class);
        GetItemRequest subject = assertInstanceOfAndCast(obj, GetItemRequest.class);
        assertEquals(subject.getPayload().getRequestContext().getUser().getId(),
                "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(),
                "e72e16c7e42f292c691234567c838347ae178b4a");
        assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
        assertEquals(subject.getPayload().getTargetItemReference().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getPayload().getTargetItemReference().getName(), "item");
        assertEquals(subject.getPayload().getTargetItemReference().getValue().getId(),
                "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getPayload().getTargetItemReference().getValue().getQueueId(),
                "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        assertEquals(subject.getPayload().getTargetItemReference().getValue().getContentId(),
                "1021012f-12bb-4938-9723-067a4338b6d0");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetItem");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}