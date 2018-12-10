package f18a14c09s.integration.alexa.music.data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * 
 */
public class GetPlayableContentRequestTest1 {public static final String TEST_CASE = "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.Search\",     \"name\": \"GetPlayableContent\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"requestContext\": {       \"user\": {         \"id\": \"amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI\",         \"accessToken\": \"e72e16c7e42f292c6912e7710c838347ae178b4a\"       },       \"location\": {         \"originatingLocale\": \"en-US\",         \"countryCode\": \"US\"       }     },     \"filters\": {       \"explicitLanguageAllowed\": true     },     \"selectionCriteria\": {       \"attributes\": [         {           \"type\": \"TRACK\",           \"entityId\": \"138545995\"         },         {           \"type\": \"MEDIA_TYPE\",           \"value\": \"TRACK\"         }       ]     }   } }";
@Test
void testDeserialization() throws IOException {
ObjectMapper jsonMapper = new ObjectMapper();Request obj = jsonMapper.readValue(TEST_CASE, Request.class);GetPlayableContentRequest subject = (GetPlayableContentRequest)obj;



assertEquals(subject.getPayload().getRequestContext().getUser().getId(), "amzn1.ask.account.AGF3NETIE4MNXNG2Z64Z27RXB6JCK2R62BCPYUZI");assertEquals(subject.getPayload().getRequestContext().getUser().getAccessToken(), "e72e16c7e42f292c6912e7710c838347ae178b4a");
assertEquals(subject.getPayload().getRequestContext().getLocation().getOriginatingLocale(), "en-US");assertEquals(subject.getPayload().getRequestContext().getLocation().getCountryCode(), "US");
assertTrue((boolean)subject.getPayload().getFilters().getExplicitLanguageAllowed());

assertEquals(subject.getPayload().getSelectionCriteria().getAttributes().get(0).getType(), "TRACK");assertEquals(subject.getPayload().getSelectionCriteria().getAttributes().get(0).getEntityId(), "138545995");
assertEquals(subject.getPayload().getSelectionCriteria().getAttributes().get(1).getType(), "MEDIA_TYPE");assertEquals(subject.getPayload().getSelectionCriteria().getAttributes().get(1).getValue(), "TRACK");
assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.Search");assertEquals(subject.getHeader().getName(), "GetPlayableContent");assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
}
}