package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static f18a14c09s.integration.alexa.music.data.ControlName.*;
import static f18a14c09s.integration.alexa.music.data.ControlType.COMMAND;
import static f18a14c09s.integration.alexa.music.data.ControlType.TOGGLE;
import static f18a14c09s.integration.alexa.music.data.MediaMetadata.Type.TRACK;
import static f18a14c09s.integration.alexa.music.data.PlaybackInfoType.DEFAULT;
import static f18a14c09s.integration.alexa.music.data.PlaybackMethodType.ALEXA_AUDIO_PLAYER_QUEUE;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.*;

/**
 * In response to the first of the preceding examples, the skill creates a queue for the user based on the requested ContentId and returns the queue identifier and the first audio item to Alexa. The Initiate response should contain enough information for Alexa to know how to manage the queue, and the first track to play for the user. To get the second track to play for the user, Alexa makes an additional call after beginning to play the first track.
 */
public class InitiateResponseTest1 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.Playback\",     \"name\": \"Initiate.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"playbackMethod\": {       \"type\": \"ALEXA_AUDIO_PLAYER_QUEUE\",       \"id\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",       \"controls\": [         {           \"type\": \"TOGGLE\",           \"name\": \"SHUFFLE\",           \"enabled\": true,           \"selected\": false         },         {           \"type\": \"TOGGLE\",           \"name\": \"LOOP\",           \"enabled\": true,           \"selected\": false         }       ],       \"rules\": {         \"feedback\": {           \"type\": \"PREFERENCE\",           \"enabled\": true         }       },       \"firstItem\": {         \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",         \"playbackInfo\": {           \"type\": \"DEFAULT\"         },         \"metadata\": {           \"type\": \"TRACK\",           \"name\": {             \"speech\": {               \"type\": \"PLAIN_TEXT\",               \"text\": \"jeremy\"             },             \"display\": \"Jeremy\"           },           \"art\": {             \"sources\": [               {                 \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",                 \"size\": \"X_SMALL\",                 \"widthPixels\": 48,                 \"heightPixels\": 48               },               {                 \"url\": \"https://example.com/images/cover/60x60-000000-80-0-0.jpg\",                 \"size\": \"SMALL\",                 \"widthPixels\": 60,                 \"heightPixels\": 60               },               {                 \"url\": \"https://example.com/images/cover/110x110-000000-80-0-0.jpg\",                 \"size\": \"MEDIUM\",                 \"widthPixels\": 110,                 \"heightPixels\": 110               },               {                 \"url\": \"https://example.com/images/cover/256x256-000000-80-0-0.jpg\",                 \"size\": \"LARGE\",                 \"widthPixels\": 256,                 \"heightPixels\": 256               },               {                 \"url\": \"https://example.com/images/cover/600x600-000000-80-0-0.jpg\",                 \"size\": \"X_LARGE\",                 \"widthPixels\": 600,                 \"heightPixels\": 600               }             ]           }         },         \"durationInMilliseconds\": 318000,         \"controls\": [           {             \"type\": \"COMMAND\",             \"name\": \"NEXT\",             \"enabled\": true           },           {             \"type\": \"COMMAND\",             \"name\": \"PREVIOUS\",             \"enabled\": false           }         ],         \"rules\": {           \"feedbackEnabled\": true         },         \"stream\": {           \"id\": \"STREAMID_92_14629004\",           \"uri\": \"https://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3\",           \"offsetInMilliseconds\": 0,           \"validUntil\": \"2018-05-10T19:11:35Z\"         },         \"feedback\": {           \"type\": \"PREFERENCE\",           \"value\": \"POSITIVE\"         }       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        InitiateResponse subject = (InitiateResponse) obj;
        AudioPlayerQueue audioPlayerQueue =
                assertInstanceOfAndCast(subject.getPayload().getPlaybackMethod(), AudioPlayerQueue.class);
        assertEquals(audioPlayerQueue.getType(), ALEXA_AUDIO_PLAYER_QUEUE);
        assertEquals(audioPlayerQueue.getId(), "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        ToggleQueueControl toggleQueueControl =
                assertInstanceOfAndCast(audioPlayerQueue.getControls().get(0), ToggleQueueControl.class);
        assertEquals(toggleQueueControl.getType(), TOGGLE);
        assertEquals(toggleQueueControl.getName(), SHUFFLE);
        assertTrue((boolean) toggleQueueControl.getEnabled());
        assertFalse((boolean) toggleQueueControl.getSelected());
        toggleQueueControl = assertInstanceOfAndCast(audioPlayerQueue.getControls().get(1), ToggleQueueControl.class);
        assertEquals(toggleQueueControl.getType(), TOGGLE);
        assertEquals(toggleQueueControl.getName(), LOOP);
        assertTrue((boolean) toggleQueueControl.getEnabled());
        assertFalse((boolean) toggleQueueControl.getSelected());
        assertEquals(audioPlayerQueue.getRules().getFeedback().getType(), "PREFERENCE");
        assertTrue((boolean) audioPlayerQueue.getRules().getFeedback().getEnabled());
        assertEquals(audioPlayerQueue.getFirstItem().getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(audioPlayerQueue.getFirstItem().getPlaybackInfo().getType(), DEFAULT);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getType(), TRACK);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getName().getSpeech().getText(), "jeremy");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getName().getDisplay(), "Jeremy");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(0).getUrl(),
                "https://example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(0).getSize(), "X_SMALL");
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getHeightPixels()).longValue(), 48L);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(1).getUrl(),
                "https://example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(1).getSize(), "SMALL");
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getHeightPixels()).longValue(), 60L);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(2).getUrl(),
                "https://example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(2).getSize(), "MEDIUM");
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getHeightPixels()).longValue(), 110L);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(3).getUrl(),
                "https://example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(3).getSize(), "LARGE");
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getHeightPixels()).longValue(), 256L);
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(4).getUrl(),
                "https://example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(audioPlayerQueue.getFirstItem().getMetadata().getArt().getSources().get(4).getSize(), "X_LARGE");
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) audioPlayerQueue.getFirstItem()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getHeightPixels()).longValue(), 600L);
        assertEquals(((Number) audioPlayerQueue.getFirstItem().getDurationInMilliseconds()).longValue(), 318000L);
        assertEquals(audioPlayerQueue.getFirstItem().getControls().get(0).getType(), COMMAND);
        assertEquals(audioPlayerQueue.getFirstItem().getControls().get(0).getName(), NEXT);
        assertTrue((boolean) audioPlayerQueue.getFirstItem().getControls().get(0).getEnabled());
        assertEquals(audioPlayerQueue.getFirstItem().getControls().get(1).getType(), COMMAND);
        assertEquals(audioPlayerQueue.getFirstItem().getControls().get(1).getName(), PREVIOUS);
        assertFalse((boolean) audioPlayerQueue.getFirstItem().getControls().get(1).getEnabled());
        assertTrue((boolean) audioPlayerQueue.getFirstItem().getRules().getFeedbackEnabled());
        assertEquals(audioPlayerQueue.getFirstItem().getStream().getId(), "STREAMID_92_14629004");
        assertEquals(audioPlayerQueue.getFirstItem().getStream().getUri(),
                "https://cdn.example.com/api/1/a2f318467fbf2829996adc0880e0abd03d03b1ba6ac.mp3");
        assertEquals(((Number) audioPlayerQueue.getFirstItem().getStream().getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(audioPlayerQueue.getFirstItem().getStream().getValidUntil(), "2018-05-10T19:11:35Z");
        assertEquals(audioPlayerQueue.getFirstItem().getFeedback().getType(), "PREFERENCE");
        assertEquals(audioPlayerQueue.getFirstItem().getFeedback().getValue(), "POSITIVE");
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.Playback");
        assertEquals(subject.getHeader().getName(), "Initiate.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}