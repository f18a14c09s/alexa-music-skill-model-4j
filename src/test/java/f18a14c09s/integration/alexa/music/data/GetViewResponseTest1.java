package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.*;

/**
 * If the skill can return a list of upcoming items, it should respond with a GetView.Response message like the following example.
 */
public class GetViewResponseTest1 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetView.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"queueControls\": [       {         \"type\": \"TOGGLE\",         \"name\": \"SHUFFLE\",         \"enabled\": true,         \"selected\": false       },       {         \"type\": \"TOGGLE\",         \"name\": \"LOOP\",         \"enabled\": true,         \"selected\": false       }     ],     \"items\": [       {         \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",         \"playbackInfo\": {           \"type\": \"DEFAULT\"         },         \"metadata\": {           \"type\": \"TRACK\",           \"name\": {             \"speech\": {               \"type\": \"PLAIN_TEXT\",               \"text\": \"alive\"             },             \"display\": \"Alive\"           },           \"art\": {             \"sources\": [               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"X_SMALL\",                 \"widthPixels\": 48,                 \"heightPixels\": 48               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"SMALL\",                 \"widthPixels\": 60,                 \"heightPixels\": 60               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"MEDIUM\",                 \"widthPixels\": 110,                 \"heightPixels\": 110               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"LARGE\",                 \"widthPixels\": 256,                 \"heightPixels\": 256               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"X_LARGE\",                 \"widthPixels\": 600,                 \"heightPixels\": 600               }             ]           }         },         \"durationInMilliseconds\": 428000,         \"controls\": [           {             \"type\": \"COMMAND\",             \"name\": \"NEXT\",             \"enabled\": true           },           {             \"type\": \"COMMAND\",             \"name\": \"PREVIOUS\",             \"enabled\": false           }         ],         \"rules\": {           \"feedbackEnabled\": true         },         \"stream\": {           \"id\": \"STREAMID_92_14629004\",           \"uri\": \"https://cdn.example.com/api/1/streaming-file.mp3\",           \"offsetInMilliseconds\": 0,           \"validUntil\": \"2018-05-10T19:11:35Z\"         },         \"feedback\": {           \"type\": \"PREFERENCE\",           \"value\": \"POSITIVE\"         }       },       {         \"id\": \"533718fe-b22d-4f64-8b1c-49ffdb85f619\",         \"playbackInfo\": {           \"type\": \"DEFAULT\"         },         \"metadata\": {           \"type\": \"TRACK\",           \"name\": {             \"speech\": {               \"type\": \"PLAIN_TEXT\",               \"text\": \"porch\"             },             \"display\": \"Porch\"           },           \"art\": {             \"sources\": [               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"X_SMALL\",                 \"widthPixels\": 48,                 \"heightPixels\": 48               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"SMALL\",                 \"widthPixels\": 60,                 \"heightPixels\": 60               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"MEDIUM\",                 \"widthPixels\": 110,                 \"heightPixels\": 110               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"LARGE\",                 \"widthPixels\": 256,                 \"heightPixels\": 256               },               {                 \"url\": \"https://images.example.com/images/cover/album-art.jpg\",                 \"size\": \"X_LARGE\",                 \"widthPixels\": 600,                 \"heightPixels\": 600               }             ]           }         },         \"durationInMilliseconds\": 449000,         \"controls\": [           {             \"type\": \"COMMAND\",             \"name\": \"NEXT\",             \"enabled\": false           },           {             \"type\": \"COMMAND\",             \"name\": \"PREVIOUS\",             \"enabled\": false           }         ],         \"rules\": {           \"feedbackEnabled\": true         },         \"stream\": {           \"id\": \"STREAMID_92_14629005\",           \"uri\": \"https://cdn.example.com/api/1/streaming-file.mp3\",           \"offsetInMilliseconds\": 0,           \"validUntil\": \"2018-05-10T19:11:35Z\"         },         \"feedback\": {           \"type\": \"PREFERENCE\",           \"value\": \"POSITIVE\"         }       }     ]   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        GetViewResponse subject = (GetViewResponse) obj;
        ToggleQueueControl toggleQueueControl =
                assertInstanceOfAndCast(subject.getPayload().getQueueControls().get(0), ToggleQueueControl.class);
        assertEquals(toggleQueueControl.getType(), "TOGGLE");
        assertEquals(toggleQueueControl.getName(), "SHUFFLE");
        assertTrue((boolean) toggleQueueControl.getEnabled());
        assertFalse((boolean) toggleQueueControl.getSelected());
        toggleQueueControl =
                assertInstanceOfAndCast(subject.getPayload().getQueueControls().get(1), ToggleQueueControl.class);
        assertEquals(toggleQueueControl.getType(), "TOGGLE");
        assertEquals(toggleQueueControl.getName(), "LOOP");
        assertTrue((boolean) toggleQueueControl.getEnabled());
        assertFalse((boolean) toggleQueueControl.getSelected());
        assertEquals(subject.getPayload().getItems().get(0).getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getPayload().getItems().get(0).getPlaybackInfo().getType(), "DEFAULT");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getType(), "TRACK");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getName().getSpeech().getType(),
                "PLAIN_TEXT");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getName().getSpeech().getText(), "alive");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getName().getDisplay(), "Alive");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(0).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(0).getSize(),
                "X_SMALL");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getHeightPixels()).longValue(), 48L);
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(1).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(1).getSize(),
                "SMALL");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getHeightPixels()).longValue(), 60L);
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(2).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(2).getSize(),
                "MEDIUM");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getHeightPixels()).longValue(), 110L);
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(3).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(3).getSize(),
                "LARGE");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getHeightPixels()).longValue(), 256L);
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(4).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(0).getMetadata().getArt().getSources().get(4).getSize(),
                "X_LARGE");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getHeightPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload().getItems().get(0).getDurationInMilliseconds()).longValue(),
                428000L);
        assertEquals(subject.getPayload().getItems().get(0).getControls().get(0).getType(), "COMMAND");
        assertEquals(subject.getPayload().getItems().get(0).getControls().get(0).getName(), "NEXT");
        assertTrue((boolean) subject.getPayload().getItems().get(0).getControls().get(0).getEnabled());
        assertEquals(subject.getPayload().getItems().get(0).getControls().get(1).getType(), "COMMAND");
        assertEquals(subject.getPayload().getItems().get(0).getControls().get(1).getName(), "PREVIOUS");
        assertFalse((boolean) subject.getPayload().getItems().get(0).getControls().get(1).getEnabled());
        assertTrue((boolean) subject.getPayload().getItems().get(0).getRules().getFeedbackEnabled());
        assertEquals(subject.getPayload().getItems().get(0).getStream().getId(), "STREAMID_92_14629004");
        assertEquals(subject.getPayload().getItems().get(0).getStream().getUri(),
                "https://cdn.example.com/api/1/streaming-file.mp3");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(0)
                .getStream()
                .getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getPayload().getItems().get(0).getStream().getValidUntil(), "2018-05-10T19:11:35Z");
        assertEquals(subject.getPayload().getItems().get(0).getFeedback().getType(), "PREFERENCE");
        assertEquals(subject.getPayload().getItems().get(0).getFeedback().getValue(), "POSITIVE");
        assertEquals(subject.getPayload().getItems().get(1).getId(), "533718fe-b22d-4f64-8b1c-49ffdb85f619");
        assertEquals(subject.getPayload().getItems().get(1).getPlaybackInfo().getType(), "DEFAULT");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getType(), "TRACK");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getName().getSpeech().getType(),
                "PLAIN_TEXT");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getName().getSpeech().getText(), "porch");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getName().getDisplay(), "Porch");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(0).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(0).getSize(),
                "X_SMALL");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getHeightPixels()).longValue(), 48L);
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(1).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(1).getSize(),
                "SMALL");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getHeightPixels()).longValue(), 60L);
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(2).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(2).getSize(),
                "MEDIUM");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getHeightPixels()).longValue(), 110L);
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(3).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(3).getSize(),
                "LARGE");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getHeightPixels()).longValue(), 256L);
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(4).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
        assertEquals(subject.getPayload().getItems().get(1).getMetadata().getArt().getSources().get(4).getSize(),
                "X_LARGE");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getHeightPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload().getItems().get(1).getDurationInMilliseconds()).longValue(),
                449000L);
        assertEquals(subject.getPayload().getItems().get(1).getControls().get(0).getType(), "COMMAND");
        assertEquals(subject.getPayload().getItems().get(1).getControls().get(0).getName(), "NEXT");
        assertFalse((boolean) subject.getPayload().getItems().get(1).getControls().get(0).getEnabled());
        assertEquals(subject.getPayload().getItems().get(1).getControls().get(1).getType(), "COMMAND");
        assertEquals(subject.getPayload().getItems().get(1).getControls().get(1).getName(), "PREVIOUS");
        assertFalse((boolean) subject.getPayload().getItems().get(1).getControls().get(1).getEnabled());
        assertTrue((boolean) subject.getPayload().getItems().get(1).getRules().getFeedbackEnabled());
        assertEquals(subject.getPayload().getItems().get(1).getStream().getId(), "STREAMID_92_14629005");
        assertEquals(subject.getPayload().getItems().get(1).getStream().getUri(),
                "https://cdn.example.com/api/1/streaming-file.mp3");
        assertEquals(((Number) subject.getPayload()
                .getItems()
                .get(1)
                .getStream()
                .getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getPayload().getItems().get(1).getStream().getValidUntil(), "2018-05-10T19:11:35Z");
        assertEquals(subject.getPayload().getItems().get(1).getFeedback().getType(), "PREFERENCE");
        assertEquals(subject.getPayload().getItems().get(1).getFeedback().getValue(), "POSITIVE");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetView.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}