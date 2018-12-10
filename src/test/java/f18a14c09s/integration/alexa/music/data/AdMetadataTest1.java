package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.music.metadata.AdMetadata;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static f18a14c09s.integration.alexa.music.data.ArtSourceSize.*;
import static f18a14c09s.integration.alexa.music.metadata.MetadataType.AD;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class AdMetadataTest1 {
    public static final String TEST_CASE =
            "{   \"type\": \"AD\",   \"name\": {     \"speech\": {       \"type\": \"PLAIN_TEXT\",       \"text\": \"some advertisement\"     },     \"display\": \"Some advertisement\"   },   \"art\": {     \"sources\": [       {         \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",         \"size\": \"X_SMALL\",         \"widthPixels\": 48,         \"heightPixels\": 48       },       {         \"url\": \"https://example.com/images/cover/60x60-000000-80-0-0.jpg\",         \"size\": \"SMALL\",         \"widthPixels\": 60,         \"heightPixels\": 60       },       {         \"url\": \"https://example.com/images/cover/110x110-000000-80-0-0.jpg\",         \"size\": \"MEDIUM\",         \"widthPixels\": 110,         \"heightPixels\": 110       },       {         \"url\": \"https://example.com/images/cover/256x256-000000-80-0-0.jpg\",         \"size\": \"LARGE\",         \"widthPixels\": 256,         \"heightPixels\": 256       },       {         \"url\": \"https://example.com/images/cover/600x600-000000-80-0-0.jpg\",         \"size\": \"X_LARGE\",         \"widthPixels\": 600,         \"heightPixels\": 600       }     ]   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        AdMetadata subject = jsonMapper.readValue(TEST_CASE, AdMetadata.class);
        assertEquals(subject.getArt().getSources().get(0).getUrl(),
                "https://example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(subject.getArt().getSources().get(0).getSize(), X_SMALL);
        assertEquals(((Number) subject.getArt().getSources().get(0).getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) subject.getArt().getSources().get(0).getHeightPixels()).longValue(), 48L);
        assertEquals(subject.getArt().getSources().get(1).getUrl(),
                "https://example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(subject.getArt().getSources().get(1).getSize(), SMALL);
        assertEquals(((Number) subject.getArt().getSources().get(1).getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) subject.getArt().getSources().get(1).getHeightPixels()).longValue(), 60L);
        assertEquals(subject.getArt().getSources().get(2).getUrl(),
                "https://example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(subject.getArt().getSources().get(2).getSize(), MEDIUM);
        assertEquals(((Number) subject.getArt().getSources().get(2).getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) subject.getArt().getSources().get(2).getHeightPixels()).longValue(), 110L);
        assertEquals(subject.getArt().getSources().get(3).getUrl(),
                "https://example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(subject.getArt().getSources().get(3).getSize(), LARGE);
        assertEquals(((Number) subject.getArt().getSources().get(3).getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) subject.getArt().getSources().get(3).getHeightPixels()).longValue(), 256L);
        assertEquals(subject.getArt().getSources().get(4).getUrl(),
                "https://example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(subject.getArt().getSources().get(4).getSize(), X_LARGE);
        assertEquals(((Number) subject.getArt().getSources().get(4).getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getArt().getSources().get(4).getHeightPixels()).longValue(), 600L);
        assertEquals(subject.getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(subject.getName().getSpeech().getText(), "some advertisement");
        assertEquals(subject.getName().getDisplay(), "Some advertisement");
        assertEquals(subject.getType(), AD);
    }
}