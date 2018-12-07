package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.data.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class InitiateResponseTest {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.Playback\",     \"name\": \"Initiate.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"playbackMethod\": {       \"type\": \"ALEXA_AUDIO_PLAYER_QUEUE\",       \"id\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",       \"controls\": [         {           \"type\": \"TOGGLE\",           \"name\": \"SHUFFLE\",           \"enabled\": true,           \"selected\": false         },         {           \"type\": \"TOGGLE\",           \"name\": \"LOOP\",           \"enabled\": true,           \"selected\": false         }       ],       \"rules\": {         \"feedback\": {           \"type\": \"PREFERENCE\",           \"enabled\": true         }       },       \"firstItem\": {         \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",         \"playbackInfo\": {           \"type\": \"DEFAULT\"         },         \"metadata\": {           \"type\": \"TRACK\",           \"name\": {             \"speech\": {               \"type\": \"PLAIN_TEXT\",               \"text\": \"jeremy\"             },             \"display\": \"Jeremy\"           },           \"art\": {             \"sources\": [               {                 \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",                 \"size\": \"X_SMALL\",                 \"widthPixels\": 48,                 \"heightPixels\": 48               },               {                 \"url\": \"https://example.com/images/cover/60x60-000000-80-0-0.jpg\",                 \"size\": \"SMALL\",                 \"widthPixels\": 60,                 \"heightPixels\": 60               },               {                 \"url\": \"https://example.com/images/cover/110x110-000000-80-0-0.jpg\",                 \"size\": \"MEDIUM\",                 \"widthPixels\": 110,                 \"heightPixels\": 110               },               {                 \"url\": \"https://example.com/images/cover/256x256-000000-80-0-0.jpg\",                 \"size\": \"LARGE\",                 \"widthPixels\": 256,                 \"heightPixels\": 256               },               {                 \"url\": \"https://example.com/images/cover/600x600-000000-80-0-0.jpg\",                 \"size\": \"X_LARGE\",                 \"widthPixels\": 600,                 \"heightPixels\": 600               }             ]           }         },         \"durationInMilliseconds\": 318000,         \"controls\": [           {             \"type\": \"COMMAND\",             \"name\": \"NEXT\",             \"enabled\": true           },           {             \"type\": \"COMMAND\",             \"name\": \"PREVIOUS\",             \"enabled\": false           }         ],         \"rules\": {           \"feedbackEnabled\": true         },         \"stream\": {           \"id\": \"STREAMID_92_14629004\",           \"uri\": \"https://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3\",           \"offsetInMilliseconds\": 0,           \"validUntil\": \"2018-05-10T19:11:35Z\"         },         \"feedback\": {           \"type\": \"PREFERENCE\",           \"value\": \"POSITIVE\"         }       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        InitiateResponse subject = (InitiateResponse) obj;


        assertEquals(subject.getPayload().getPlaybackMethod().getType(), "ALEXA_AUDIO_PLAYER_QUEUE");
        assertEquals(subject.getPayload().getPlaybackMethod().getId(), "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        assertEquals(subject.getPayload().getPlaybackMethod().getControls().get(0).getType(), "TOGGLE");
        assertEquals(subject.getPayload().getPlaybackMethod().getControls().get(0).getName(), "SHUFFLE");
        assertTrue((boolean) subject.getPayload().getPlaybackMethod().getControls().get(0).getEnabled());
        assertFalse((boolean) subject.getPayload().getPlaybackMethod().getControls().get(0).getSelected());
        assertEquals(subject.getPayload().getPlaybackMethod().getControls().get(1).getType(), "TOGGLE");
        assertEquals(subject.getPayload().getPlaybackMethod().getControls().get(1).getName(), "LOOP");
        assertTrue((boolean) subject.getPayload().getPlaybackMethod().getControls().get(1).getEnabled());
        assertFalse((boolean) subject.getPayload().getPlaybackMethod().getControls().get(1).getSelected());

        assertEquals(subject.getPayload().getPlaybackMethod().getRules().getFeedback().getType(), "PREFERENCE");
        assertTrue((boolean) subject.getPayload().getPlaybackMethod().getRules().getFeedback().getEnabled());
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getId(),
                "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getPlaybackInfo().getType(), "DEFAULT");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getMetadata().getType(), "TRACK");

        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getName()
                .getSpeech()
                .getType(), "PLAIN_TEXT");
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getName()
                .getSpeech()
                .getText(), "jeremy");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getMetadata().getName().getDisplay(),
                "Jeremy");

        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getUrl(), "https://example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getSize(), "X_SMALL");
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getHeightPixels()).longValue(), 48L);
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getUrl(), "https://example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getSize(), "SMALL");
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getHeightPixels()).longValue(), 60L);
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getUrl(), "https://example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getSize(), "MEDIUM");
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getHeightPixels()).longValue(), 110L);
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getUrl(), "https://example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getSize(), "LARGE");
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getHeightPixels()).longValue(), 256L);
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getUrl(), "https://example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getSize(), "X_LARGE");
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getHeightPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getDurationInMilliseconds()).longValue(), 318000L);
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getControls().get(0).getType(), "COMMAND");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getControls().get(0).getName(), "NEXT");
        assertTrue((boolean) subject.getPayload().getPlaybackMethod().getFirstItem().getControls().get(0).getEnabled());
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getControls().get(1).getType(), "COMMAND");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getControls().get(1).getName(),
                "PREVIOUS");
        assertFalse((boolean) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getControls()
                .get(1)
                .getEnabled());
        assertTrue((boolean) subject.getPayload().getPlaybackMethod().getFirstItem().getRules().getFeedbackEnabled());
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getStream().getId(),
                "STREAMID_92_14629004");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getStream().getUri(),
                "https://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3");
        assertEquals(((Number) subject.getPayload()
                .getPlaybackMethod()
                .getFirstItem()
                .getStream()
                .getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getStream().getValidUntil(),
                "2018-05-10T19:11:35Z");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getFeedback().getType(), "PREFERENCE");
        assertEquals(subject.getPayload().getPlaybackMethod().getFirstItem().getFeedback().getValue(), "POSITIVE");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.Playback");
        assertEquals(subject.getHeader().getName(), "Initiate.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}