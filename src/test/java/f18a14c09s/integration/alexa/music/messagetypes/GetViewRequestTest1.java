package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * When Alexa is playing music from a music skill and the user opens the "Now Playing" screen in the Alexa app, Alexa sends a GetView request like the following example.
 */
public class GetViewRequestTest1 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.PlayQueue\",     \"name\": \"GetView\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"currentItemReference\": {       \"namespace\": \"Alexa.Audio.PlayQueue\",       \"name\": \"item\",       \"value\": {         \"id\": \"e73befbe-8c27-4e4b-9865ce8516f0\",         \"queueId\": \"76f325d5-a648-87ad-6e53cf99e4c7\",         \"contentId\": \"1021012f-12bb-9723-067a4338b6d0\"       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Request obj = jsonMapper.readValue(TEST_CASE, Request.class);
        GetViewRequest subject = assertInstanceOfAndCast(obj, GetViewRequest.class);


        assertEquals(subject.getPayload().getRequestContext().getUser().getId(),
                "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(),
                "e72e16c7e710c838347ae178b4a");
        assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
        assertEquals(subject.getPayload().getCurrentItemReference().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getPayload().getCurrentItemReference().getName(), "item");
        assertEquals(subject.getPayload().getCurrentItemReference().getValue().getId(),
                "e73befbe-8c27-4e4b-9865ce8516f0");
        assertEquals(subject.getPayload().getCurrentItemReference().getValue().getQueueId(),
                "76f325d5-a648-87ad-6e53cf99e4c7");
        assertEquals(subject.getPayload().getCurrentItemReference().getValue().getContentId(),
                "1021012f-12bb-9723-067a4338b6d0");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetView");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}