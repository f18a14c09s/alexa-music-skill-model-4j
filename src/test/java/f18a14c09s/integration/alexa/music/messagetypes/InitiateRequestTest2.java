package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The following example demonstrates the case where a user requests content (similar to the preceding example), but the user is already listening to music from the skill on the target device. In this case, Alexa exposes this information in the request, as shown in the following example (see currentItemReference).
 */
public class InitiateRequestTest2 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.Playback\",     \"name\": \"Initiate\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"filters\": {       \"explicitLanguageAllowed\": true     },     \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\",     \"currentItemReference\": {       \"namespace\": \"Alexa.Audio.PlayQueue\",       \"name\": \"item\",       \"value\": {         \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",         \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",         \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\"       }     },     \"playbackModes\": {       \"shuffle\": false,       \"loop\": false     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Request obj = jsonMapper.readValue(TEST_CASE, Request.class);
        InitiateRequest subject = assertInstanceOfAndCast(obj, InitiateRequest.class);


        assertEquals(subject.getPayload().getRequestContext().getUser().getId(),
                "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(),
                "e72e16c7e42f292c6912e7710c838347ae178b4a");
        assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
        assertTrue((boolean) subject.getPayload().getFilters().getExplicitLanguageAllowed());
        assertEquals(subject.getPayload().getContentId(), "1021012f-12bb-4938-9723-067a4338b6d0");
        assertEquals(subject.getPayload().getCurrentItemReference().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getPayload().getCurrentItemReference().getName(), "item");
        assertEquals(subject.getPayload().getCurrentItemReference().getValue().getId(),
                "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getPayload().getCurrentItemReference().getValue().getQueueId(),
                "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        assertEquals(subject.getPayload().getCurrentItemReference().getValue().getContentId(),
                "1021012f-12bb-4938-9723-067a4338b6d0");
        assertFalse((boolean) subject.getPayload().getPlaybackModes().getShuffle());
        assertFalse((boolean) subject.getPayload().getPlaybackModes().getLoop());
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.Playback");
        assertEquals(subject.getHeader().getName(), "Initiate");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}