package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * When a user says "Alexa, previous" while listening to a song in a queue, Alexa sends a GetPreviousItem request as in the following example.
 */
public class GetPreviousItemRequestTest1 {
    /**
     * Retrieved from https://developer.amazon.com/docs/music-skills/api-getpreviousitem.html#example-getpreviousitem-requests.
     * This test case appears to be invalid, according to the structure specified for the ItemReference component:
     * https://developer.amazon.com/docs/music-skills/api-components-reference.html#itemreference.
     */
    public static final String REFERENCE_TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetPreviousItem\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"currentItemReference\": {       \"id\": \"533718fe-b22d-4f64-8b1c-49ffdb85f619\",       \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",       \"content\": {         \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",         \"metadataType\": \"TRACK\"       }     }   } }";
    /**
     * This is a modified version of "REFERENCE_TEST_CASE" that conforms to the structure of the ItemReference component.
     */
    public static final String MODIFIED_TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetPreviousItem\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"currentItemReference\": {       \"id\": \"533718fe-b22d-4f64-8b1c-49ffdb85f619\",       \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",       \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\"     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Request obj = jsonMapper.readValue(MODIFIED_TEST_CASE, Request.class);
        GetPreviousItemRequest subject = (GetPreviousItemRequest) obj;


        assertEquals(subject.getPayload().getRequestContext().getUser().getId(),
                "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");
        assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(),
                "e72e16c7e42f292c6912e7710c838347ae178b4a");
        assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
        assertEquals(subject.getPayload().getCurrentItemReference().getId(), "533718fe-b22d-4f64-8b1c-49ffdb85f619");
        assertEquals(subject.getPayload().getCurrentItemReference().getQueueId(),
                "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        assertEquals(subject.getPayload().getCurrentItemReference().getContentId(),
                "1021012f-12bb-4938-9723-067a4338b6d0");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetPreviousItem");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}