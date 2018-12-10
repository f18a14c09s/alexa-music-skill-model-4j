package f18a14c09s.integration.alexa.music.data;import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static f18a14c09s.integration.alexa.music.data.ControlName.NEXT;
import static f18a14c09s.integration.alexa.music.data.ControlName.PREVIOUS;
import static f18a14c09s.integration.alexa.music.data.ControlType.COMMAND;
import static f18a14c09s.integration.alexa.music.data.MediaMetadata.Type.TRACK;
import static f18a14c09s.integration.alexa.music.data.PlaybackInfoType.DEFAULT;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ItemTest1 {
    public static final String TEST_CASE =
            "{   \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",   \"playbackInfo\": {     \"type\": \"DEFAULT\"   },   \"metadata\": {     \"type\": \"TRACK\",     \"name\": {       \"speech\": {         \"type\": \"PLAIN_TEXT\",         \"text\": \"gypsy\"       },       \"display\": \"Gypsy\"     },     \"authors\": [       {         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"lady gaga\"           },           \"display\": \"Lady Gaga\"         }       }     ],     \"album\": {       \"name\": {         \"speech\": {           \"type\": \"PLAIN_TEXT\",           \"text\": \"art pop\"         },         \"display\": \"ARTPOP\"       }     },     \"art\": {       \"sources\": [         {           \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",           \"size\": \"X_SMALL\",           \"widthPixels\": 48,           \"heightPixels\": 48         },         {           \"url\": \"https://example.com/images/cover/60x60-000000-80-0-0.jpg\",           \"size\": \"SMALL\",           \"widthPixels\": 60,           \"heightPixels\": 60         },         {           \"url\": \"https://example.com/images/cover/110x110-000000-80-0-0.jpg\",           \"size\": \"MEDIUM\",           \"widthPixels\": 110,           \"heightPixels\": 110         },         {           \"url\": \"https://example.com/images/cover/256x256-000000-80-0-0.jpg\",           \"size\": \"LARGE\",           \"widthPixels\": 256,           \"heightPixels\": 256         },         {           \"url\": \"https://example.com/images/cover/600x600-000000-80-0-0.jpg\",           \"size\": \"X_LARGE\",           \"widthPixels\": 600,           \"heightPixels\": 600         }       ]     }   },   \"durationInMilliseconds\": 248000,   \"controls\": [     {       \"type\": \"COMMAND\",       \"name\": \"NEXT\",       \"enabled\": true     },     {       \"type\": \"COMMAND\",       \"name\": \"PREVIOUS\",       \"enabled\": false     }   ],   \"rules\": {     \"feedbackEnabled\": true   },   \"stream\": {     \"id\": \"STREAMID_92_14629004\",     \"uri\": \"http://cdn.example.com/api/1/a2f318467fbf282999|6adc0880e0abd03d03b1ba6ac.mp3\",     \"offsetInMilliseconds\": 0,     \"validUntil\": \"2018-05-10T19:11:35Z\"   },   \"feedback\": {     \"type\": \"PREFERENCE\",     \"value\": \"POSITIVE\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Item subject = jsonMapper.readValue(TEST_CASE, Item.class);
        assertEquals(subject.getFeedback().getType(), "PREFERENCE");
        assertEquals(subject.getFeedback().getValue(), "POSITIVE");
        TrackMetadata trackMetadata = assertInstanceOfAndCast(subject.getMetadata(), TrackMetadata.class);
        assertEquals(trackMetadata.getType(), TRACK);
        assertEquals(trackMetadata.getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getName().getSpeech().getText(), "gypsy");
        assertEquals(trackMetadata.getName().getDisplay(), "Gypsy");
        assertEquals(trackMetadata.getAuthors().get(0).getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getAuthors().get(0).getName().getSpeech().getText(), "lady gaga");
        assertEquals(trackMetadata.getAuthors().get(0).getName().getDisplay(), "Lady Gaga");
        assertEquals(trackMetadata.getAlbum().getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getAlbum().getName().getSpeech().getText(), "art pop");
        assertEquals(trackMetadata.getAlbum().getName().getDisplay(), "ARTPOP");
        assertEquals(trackMetadata.getArt().getSources().get(0).getUrl(),
                "https://example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(0).getSize(), "X_SMALL");
        assertEquals(((Number) trackMetadata.getArt().getSources().get(0).getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(0).getHeightPixels()).longValue(), 48L);
        assertEquals(trackMetadata.getArt().getSources().get(1).getUrl(),
                "https://example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(1).getSize(), "SMALL");
        assertEquals(((Number) trackMetadata.getArt().getSources().get(1).getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(1).getHeightPixels()).longValue(), 60L);
        assertEquals(trackMetadata.getArt().getSources().get(2).getUrl(),
                "https://example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(2).getSize(), "MEDIUM");
        assertEquals(((Number) trackMetadata.getArt().getSources().get(2).getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(2).getHeightPixels()).longValue(), 110L);
        assertEquals(trackMetadata.getArt().getSources().get(3).getUrl(),
                "https://example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(3).getSize(), "LARGE");
        assertEquals(((Number) trackMetadata.getArt().getSources().get(3).getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(3).getHeightPixels()).longValue(), 256L);
        assertEquals(trackMetadata.getArt().getSources().get(4).getUrl(),
                "https://example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(4).getSize(), "X_LARGE");
        assertEquals(((Number) trackMetadata.getArt().getSources().get(4).getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(4).getHeightPixels()).longValue(), 600L);
        assertEquals(subject.getControls().get(0).getType(), COMMAND);
        assertEquals(subject.getControls().get(0).getName(), NEXT);
        assertTrue((boolean) subject.getControls().get(0).getEnabled());
        assertEquals(subject.getControls().get(1).getType(), COMMAND);
        assertEquals(subject.getControls().get(1).getName(), PREVIOUS);
        assertFalse((boolean) subject.getControls().get(1).getEnabled());
        assertEquals(subject.getStream().getId(), "STREAMID_92_14629004");
        assertEquals(subject.getStream().getUri(),
                "http://cdn.example.com/api/1/a2f318467fbf282999|6adc0880e0abd03d03b1ba6ac.mp3");
        assertEquals(((Number) subject.getStream().getOffsetInMilliseconds()).longValue(), 0L);
        assertEquals(subject.getStream().getValidUntil(), "2018-05-10T19:11:35Z");
        assertEquals(((Number) subject.getDurationInMilliseconds()).longValue(), 248000L);
        assertTrue((boolean) subject.getRules().getFeedbackEnabled());
        assertEquals(subject.getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getPlaybackInfo().getType(), DEFAULT);
    }
}