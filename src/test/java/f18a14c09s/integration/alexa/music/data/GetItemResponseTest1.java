package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static f18a14c09s.integration.alexa.music.data.ControlName.NEXT;
import static f18a14c09s.integration.alexa.music.data.ControlName.PREVIOUS;
import static f18a14c09s.integration.alexa.music.data.ControlType.COMMAND;
import static f18a14c09s.integration.alexa.music.data.MediaMetadata.Type.TRACK;
import static f18a14c09s.integration.alexa.music.data.PlaybackInfoType.DEFAULT;
import static org.junit.jupiter.api.Assertions.*;

/**
 * In response to the preceding example request, the skill returns information about the item identified in the request. See the following example.
 */
public class GetItemResponseTest1 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Audio.PlayQueue\",     \"name\": \"GetItem.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"item\": {       \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",       \"playbackInfo\": {         \"type\": \"DEFAULT\"       },       \"metadata\": {         \"type\": \"TRACK\",         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"Float On\"           },           \"display\": \"float on\"         },         \"art\": {           \"sources\": [             {               \"url\": \"https://images.example.com/images/cover/album-art.jpg\",               \"size\": \"X_SMALL\",               \"widthPixels\": 48,               \"heightPixels\": 48             },             {               \"url\": \"https://images.example.com/images/cover/album-art.jpg\",               \"size\": \"SMALL\",               \"widthPixels\": 60,               \"heightPixels\": 60             },             {               \"url\": \"https://images.example.com/images/cover/album-art.jpg\",               \"size\": \"MEDIUM\",               \"widthPixels\": 110,               \"heightPixels\": 110             },             {               \"url\": \"https://images.example.com/images/cover/album-art.jpg\",               \"size\": \"LARGE\",               \"widthPixels\": 256,               \"heightPixels\": 256             },             {               \"url\": \"https://images.example.com/images/cover/album-art.jpg\",               \"size\": \"X_LARGE\",               \"widthPixels\": 600,               \"heightPixels\": 600             }           ]         }       },       \"durationInMilliseconds\": 208000,       \"controls\": [         {           \"type\": \"COMMAND\",           \"name\": \"NEXT\",           \"enabled\": true         },         {           \"type\": \"COMMAND\",           \"name\": \"PREVIOUS\",           \"enabled\": false         }       ],       \"rules\": {         \"feedbackEnabled\": true       },       \"stream\": {         \"id\": \"STREAMID_92_14629004\",         \"uri\": \"https://cdn.example.com/api/1/streaming-file.mp3\",         \"offsetInMilliseconds\": 0,         \"validUntil\": \"2018-05-10T19:11:35Z\"       },       \"feedback\": {         \"type\": \"PREFERENCE\",         \"value\": \"POSITIVE\"       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        GetItemResponse subject = (GetItemResponse) obj;


        assertEquals(subject.getPayload().getItem().getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getPayload().getItem().getPlaybackInfo().getType(), DEFAULT);
        assertEquals(subject.getPayload().getItem().getMetadata().getType(), TRACK);
        assertEquals(subject.getPayload().getItem().getMetadata().getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(subject.getPayload().getItem().getMetadata().getName().getSpeech().getText(), "Float On");
        assertEquals(subject.getPayload().getItem().getMetadata().getName().getDisplay(), "float on");

        assertEquals(subject.getPayload().getItem().getMetadata().getArt().getSources().get(0).getUrl(),
                "https://images.example.com/images/cover/album-art.jpg");
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
                "https://images.example.com/images/cover/album-art.jpg");
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
                "https://images.example.com/images/cover/album-art.jpg");
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
                "https://images.example.com/images/cover/album-art.jpg");
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
                "https://images.example.com/images/cover/album-art.jpg");
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
        assertEquals(((Number) subject.getPayload().getItem().getDurationInMilliseconds()).longValue(), 208000L);
        assertEquals(subject.getPayload().getItem().getControls().get(0).getType(), COMMAND);
        assertEquals(subject.getPayload().getItem().getControls().get(0).getName(), NEXT);
        assertTrue((boolean) subject.getPayload().getItem().getControls().get(0).getEnabled());
        assertEquals(subject.getPayload().getItem().getControls().get(1).getType(), COMMAND);
        assertEquals(subject.getPayload().getItem().getControls().get(1).getName(), PREVIOUS);
        assertFalse((boolean) subject.getPayload().getItem().getControls().get(1).getEnabled());
        assertTrue((boolean) subject.getPayload().getItem().getRules().getFeedbackEnabled());
        assertEquals(subject.getPayload().getItem().getStream().getId(), "STREAMID_92_14629004");
        assertEquals(subject.getPayload().getItem().getStream().getUri(),
                "https://cdn.example.com/api/1/streaming-file.mp3");
        assertEquals(((Number) subject.getPayload().getItem().getStream().getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getPayload().getItem().getStream().getValidUntil(), "2018-05-10T19:11:35Z");
        assertEquals(subject.getPayload().getItem().getFeedback().getType(), "PREFERENCE");
        assertEquals(subject.getPayload().getItem().getFeedback().getValue(), "POSITIVE");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getHeader().getName(), "GetItem.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}