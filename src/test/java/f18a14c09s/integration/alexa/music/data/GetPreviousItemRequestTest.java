package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.data.Request;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GetPreviousItemRequestTest {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetPreviousItem\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"currentItemReference\": {       \"id\": \"533718fe-b22d-4f64-8b1c-49ffdb85f619\",       \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",       \"content\": {         \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",         \"metadataType\": \"TRACK\"       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Request obj = jsonMapper.readValue(TEST_CASE, Request.class);
        GetPreviousItemRequest subject = (GetPreviousItemRequest) obj;


        assertEquals(subject.getPayload().getRequestContext().getUser().getId(),
                "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(),
                "e72e16c7e42f292c6912e7710c838347ae178b4a");
        assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
        assertEquals(subject.getPayload().getCurrentItemReference().getId(), "533718fe-b22d-4f64-8b1c-49ffdb85f619");
        assertEquals(subject.getPayload().getCurrentItemReference().getQueueId(),
                "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        assertEquals(subject.getPayload().getCurrentItemReference().getContent().getId(),
                "1021012f-12bb-4938-9723-067a4338b6d0");
        assertEquals(subject.getPayload().getCurrentItemReference().getContent().getMetadataType(), "TRACK");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetPreviousItem");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}