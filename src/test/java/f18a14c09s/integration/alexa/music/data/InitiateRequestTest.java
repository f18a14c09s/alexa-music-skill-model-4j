package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.data.Request;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class InitiateRequestTest {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.Playback\",     \"name\": \"Initiate\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"filters\": {       \"explicitLanguageAllowed\": true     },     \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\",     \"playbackModes\": {       \"shuffle\": false,       \"loop\": false     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Request obj = jsonMapper.readValue(TEST_CASE, Request.class);
        InitiateRequest subject = (InitiateRequest) obj;


        assertEquals(subject.getPayload().getRequestContext().getUser().getId(),
                "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(),
                "e72e16c7e42f292c6912e7710c838347ae178b4a");
        assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
        assertTrue((boolean) subject.getPayload().getFilters().getExplicitLanguageAllowed());
        assertEquals(subject.getPayload().getContentId(), "1021012f-12bb-4938-9723-067a4338b6d0");
        assertFalse((boolean) subject.getPayload().getPlaybackModes().getShuffle());
        assertFalse((boolean) subject.getPayload().getPlaybackModes().getLoop());
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.Playback");
        assertEquals(subject.getHeader().getName(), "Initiate");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}