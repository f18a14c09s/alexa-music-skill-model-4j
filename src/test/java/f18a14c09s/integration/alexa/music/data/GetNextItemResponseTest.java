package f18a14c09s.integration.alexa.music.data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import f18a14c09s.integration.alexa.data.Response;
import java.util.*;
import java.util.function.*;
import static org.junit.jupiter.api.Assertions.*;

public class GetNextItemResponseTest {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetNextItem.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"isQueueFinished\": false,     \"item\": {       \"id\": \"533718fe-b22d-4f64-8b1c-49ffdb85f619\",       \"playbackInfo\": {         \"type\": \"DEFAULT\"       },       \"metadata\": {         \"type\": \"TRACK\",         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"in circles\"           },           \"display\": \"In Circles\"         },         \"art\": {           \"sources\": [             {               \"url\": \"https://images.example.com/images/cover/48x48-000000-80-0-0.jpg\",               \"size\": \"X_SMALL\",               \"widthPixels\": 48,               \"heightPixels\": 48             },             {               \"url\": \"https://images.example.com/images/cover/60x60-000000-80-0-0.jpg\",               \"size\": \"SMALL\",               \"widthPixels\": 60,               \"heightPixels\": 60             },             {               \"url\": \"https://images.example.com/images/cover/110x110-000000-80-0-0.jpg\",               \"size\": \"MEDIUM\",               \"widthPixels\": 110,               \"heightPixels\": 110             },             {               \"url\": \"https://images.example.com/images/cover/256x256-000000-80-0-0.jpg\",               \"size\": \"LARGE\",               \"widthPixels\": 256,               \"heightPixels\": 256             },             {               \"url\": \"https://images.example.com/images/cover/600x600-000000-80-0-0.jpg\",               \"size\": \"X_LARGE\",               \"widthPixels\": 600,               \"heightPixels\": 600             }           ]         }       },       \"durationInMilliseconds\": 276000,       \"controls\": [         {           \"type\": \"COMMAND\",           \"name\": \"NEXT\",           \"enabled\": true         },         {           \"type\": \"COMMAND\",           \"name\": \"PREVIOUS\",           \"enabled\": false         }       ],       \"rules\": {         \"feedbackEnabled\": true       },       \"stream\": {         \"id\": \"STREAMID_92_14629004\",         \"uri\": \"http://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3\",         \"offsetInMilliseconds\": 0,         \"validUntil\": \"2018-05-10T19:11:35Z\"       },       \"feedback\": {         \"type\": \"PREFERENCE\",         \"value\": \"POSITIVE\"       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        GetNextItemResponse subject = (GetNextItemResponse) obj;

        assertFalse((boolean) subject.getPayload().getIsQueueFinished());
        assertEquals(subject.getPayload().getItem().getId(), "533718fe-b22d-4f64-8b1c-49ffdb85f619");
        assertEquals(subject.getPayload().getItem().getPlaybackInfo().getType(), "DEFAULT");
        assertEquals(subject.getPayload().getItem().getMetadata().getType(), "TRACK");

        assertEquals(subject.getPayload().getItem().getMetadata().getName().getSpeech().getType(), "PLAIN_TEXT");
        assertEquals(subject.getPayload().getItem().getMetadata().getName().getSpeech().getText(), "in circles");
        assertEquals(subject.getPayload().getItem().getMetadata().getName().getDisplay(), "In Circles");

        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(0).getUrl(),
                "https://images.example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(0).getSize(), "X_SMALL");
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getHeightPixels()).longValue(), 48L);
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(1).getUrl(),
                "https://images.example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(1).getSize(), "SMALL");
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getHeightPixels()).longValue(), 60L);
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(2).getUrl(),
                "https://images.example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(2).getSize(), "MEDIUM");
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getHeightPixels()).longValue(), 110L);
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(3).getUrl(),
                "https://images.example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(3).getSize(), "LARGE");
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getHeightPixels()).longValue(), 256L);
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(4).getUrl(),
                "https://images.example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(4).getSize(), "X_LARGE");
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload()
                .getItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getHeightPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload().getItem().getDurationInMilliseconds()).longValue(), 276000L);
        assertEquals(subject.getPayload().getItem().getControls().get(0).getType(), "COMMAND");
        assertEquals(subject.getPayload().getItem().getControls().get(0).getName(), "NEXT");
        assertTrue((boolean) subject.getPayload().getItem().getControls().get(0).getEnabled());
        assertEquals(subject.getPayload().getItem().getControls().get(1).getType(), "COMMAND");
        assertEquals(subject.getPayload().getItem().getControls().get(1).getName(), "PREVIOUS");
        assertFalse((boolean) subject.getPayload().getItem().getControls().get(1).getEnabled());
        assertTrue((boolean) subject.getPayload().getItem().getRules().getFeedbackEnabled());
        assertEquals(subject.getPayload().getItem().getStream().getId(), "STREAMID_92_14629004");
        assertEquals(subject.getPayload().getItem().getStream().getUri(),
                "http://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3");
        assertEquals(((Number) subject.getPayload().getItem().getStream().getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getPayload().getItem().getStream().getValidUntil(), "2018-05-10T19:11:35Z");
        assertEquals(subject.getPayload().getItem().getFeedback().getType(), "PREFERENCE");
        assertEquals(subject.getPayload().getItem().getFeedback().getValue(), "POSITIVE");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetNextItem.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}