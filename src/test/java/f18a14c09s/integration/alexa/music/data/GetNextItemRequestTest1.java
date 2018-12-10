package f18a14c09s.integration.alexa.music.data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * When Alexa needs to get the stream URI for a track to buffer it on the device for a smooth transition, Alexa sends a GetNextItem request as in the following example.
 */
public class GetNextItemRequestTest1 {public static final String TEST_CASE = "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetNextItem\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\"       }     },     \"currentItemReference\": {       \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",       \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",       \"content\": {         \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",         \"metadataType\": \"TRACK\"       }     },     \"isUserInitiated\": false   } }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();Request obj = jsonMapper.readValue(TEST_CASE, Request.class);GetNextItemRequest subject = (GetNextItemRequest)obj;



assertEquals(subject.getPayload().getRequestContext().getUser().getId(), "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(), "e72e16c7e42f292c6912e7710c838347ae178b4a");
assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");
assertEquals(subject.getPayload().getCurrentItemReference().getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");assertEquals(subject.getPayload().getCurrentItemReference().getQueueId(), "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
assertEquals(subject.getPayload().getCurrentItemReference().getContent().getId(), "1021012f-12bb-4938-9723-067a4338b6d0");assertEquals(subject.getPayload().getCurrentItemReference().getContent().getMetadataType(), "TRACK");assertFalse((boolean)subject.getPayload().getIsUserInitiated());
assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");assertEquals(subject.getHeader().getName(), "GetNextItem");assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
}
}