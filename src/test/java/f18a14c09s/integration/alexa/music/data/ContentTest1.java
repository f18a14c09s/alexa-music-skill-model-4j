package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.music.metadata.TrackMetadata;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static f18a14c09s.integration.alexa.music.data.ArtSourceSize.*;
import static f18a14c09s.integration.alexa.music.metadata.MetadataType.TRACK;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ContentTest1 {
    public static final String REFERENCE_TEST_CASE =
            "{   \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",   \"actions\": {     \"playable\": true,     \"browsable\": false   },   \"metadata\": {     \"type\": \"TRACK\",     \"name\": {       \"speech\": {         \"type\": \"PLAIN_TEXT\",         \"text\": \"remember high school\"       },       \"display\": \"Remember High School\"     },     \"authors\": [       {         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"macklemore\"           },           \"display\": \"Macklemore\"         }       }     ],     \"album\": {       \"name\": {         \"speech\": {           \"type\": \"PLAIN_TEXT\",           \"text\": \"the language of my world\"         },         \"display\": \"The Language of My World\"       }     },     \"art\": {       \"sources\": [         {           \"url\": \"https:example.com/images/cover/48x48-000000-80-0-0.jpg\",           \"size\": \"X_SMALL\",           \"widthPixels\": 48,           \"heightPixels\": 48         },         {           \"url\": \"https:example.com/images/cover/60x60-000000-80-0-0.jpg\",           \"size\": \"SMALL\",           \"widthPixels\": 60,           \"heightPixels\": 60         },         {           \"url\": \"https:example.com/images/cover/110x110-000000-80-0-0.jpg\",           \"size\": \"MEDIUM\",           \"widthPixels\": 110,           \"heightPixels\": 110         },         {           \"url\": \"https:example.com/images/cover/256x256-000000-80-0-0.jpg\",           \"size\": \"LARGE\",           \"widthPixels\": 256,           \"heightPixels\": 256         },         {           \"url\": \"https:example.com/images/cover/600x600-000000-80-0-0.jpg\",           \"size\": \"X_LARGE\",           \"widthPixels\": 600,           \"heightPixels\": 600         }       ]     }   } }";
    public static final String MODIFIED_TEST_CASE =
            "{   \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",   \"actions\": {     \"playable\": true,     \"browsable\": false   },   \"metadata\": {     \"type\": \"TRACK\",     \"name\": {       \"speech\": {         \"type\": \"PLAIN_TEXT\",         \"text\": \"remember high school\"       },       \"display\": \"Remember High School\"     },     \"authors\": [       {         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"macklemore\"           },           \"display\": \"Macklemore\"         }       }     ],     \"album\": {       \"name\": {         \"speech\": {           \"type\": \"PLAIN_TEXT\",           \"text\": \"the language of my world\"         },         \"display\": \"The Language of My World\"       }     },     \"art\": {       \"sources\": [         {           \"url\": \"https:example.com/images/cover/48x48-000000-80-0-0.jpg\",           \"size\": \"X_SMALL\",           \"widthPixels\": 48,           \"heightPixels\": 48         },         {           \"url\": \"https:example.com/images/cover/60x60-000000-80-0-0.jpg\",           \"size\": \"SMALL\",           \"widthPixels\": 60,           \"heightPixels\": 60         },         {           \"url\": \"https:example.com/images/cover/110x110-000000-80-0-0.jpg\",           \"size\": \"MEDIUM\",           \"widthPixels\": 110,           \"heightPixels\": 110         },         {           \"url\": \"https:example.com/images/cover/256x256-000000-80-0-0.jpg\",           \"size\": \"LARGE\",           \"widthPixels\": 256,           \"heightPixels\": 256         },         {           \"url\": \"https:example.com/images/cover/600x600-000000-80-0-0.jpg\",           \"size\": \"X_LARGE\",           \"widthPixels\": 600,           \"heightPixels\": 600         }       ]     }   } }";
//     public static final String MODIFIED_TEST_CASE =
//             "{   \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",   \"actions\": {     \"playable\": true,     \"browseable\": false   },   \"metadata\": {     \"type\": \"TRACK\",     \"name\": {       \"speech\": {         \"type\": \"PLAIN_TEXT\",         \"text\": \"remember high school\"       },       \"display\": \"Remember High School\"     },     \"authors\": [       {         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"macklemore\"           },           \"display\": \"Macklemore\"         }       }     ],     \"album\": {       \"name\": {         \"speech\": {           \"type\": \"PLAIN_TEXT\",           \"text\": \"the language of my world\"         },         \"display\": \"The Language of My World\"       }     },     \"art\": {       \"sources\": [         {           \"url\": \"https:example.com/images/cover/48x48-000000-80-0-0.jpg\",           \"size\": \"X_SMALL\",           \"widthPixels\": 48,           \"heightPixels\": 48         },         {           \"url\": \"https:example.com/images/cover/60x60-000000-80-0-0.jpg\",           \"size\": \"SMALL\",           \"widthPixels\": 60,           \"heightPixels\": 60         },         {           \"url\": \"https:example.com/images/cover/110x110-000000-80-0-0.jpg\",           \"size\": \"MEDIUM\",           \"widthPixels\": 110,           \"heightPixels\": 110         },         {           \"url\": \"https:example.com/images/cover/256x256-000000-80-0-0.jpg\",           \"size\": \"LARGE\",           \"widthPixels\": 256,           \"heightPixels\": 256         },         {           \"url\": \"https:example.com/images/cover/600x600-000000-80-0-0.jpg\",           \"size\": \"X_LARGE\",           \"widthPixels\": 600,           \"heightPixels\": 600         }       ]     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Content subject = jsonMapper.readValue(MODIFIED_TEST_CASE, Content.class);
        TrackMetadata trackMetadata = assertInstanceOfAndCast(subject.getMetadata(), TrackMetadata.class);
        assertEquals(trackMetadata.getType(), TRACK);
        assertEquals(trackMetadata.getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getName().getSpeech().getText(), "remember high school");
        assertEquals(trackMetadata.getName().getDisplay(), "Remember High School");
        assertEquals(trackMetadata.getAuthors().get(0).getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getAuthors().get(0).getName().getSpeech().getText(), "macklemore");
        assertEquals(trackMetadata.getAuthors().get(0).getName().getDisplay(), "Macklemore");
        assertEquals(trackMetadata.getAlbum().getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getAlbum().getName().getSpeech().getText(), "the language of my world");
        assertEquals(trackMetadata.getAlbum().getName().getDisplay(), "The Language of My World");
        assertEquals(trackMetadata.getArt().getSources().get(0).getUrl(),
                "https:example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(0).getSize(), X_SMALL);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(0).getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(0).getHeightPixels()).longValue(), 48L);
        assertEquals(trackMetadata.getArt().getSources().get(1).getUrl(),
                "https:example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(1).getSize(), SMALL);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(1).getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(1).getHeightPixels()).longValue(), 60L);
        assertEquals(trackMetadata.getArt().getSources().get(2).getUrl(),
                "https:example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(2).getSize(), MEDIUM);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(2).getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(2).getHeightPixels()).longValue(), 110L);
        assertEquals(trackMetadata.getArt().getSources().get(3).getUrl(),
                "https:example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(3).getSize(), LARGE);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(3).getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(3).getHeightPixels()).longValue(), 256L);
        assertEquals(trackMetadata.getArt().getSources().get(4).getUrl(),
                "https:example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(trackMetadata.getArt().getSources().get(4).getSize(), X_LARGE);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(4).getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) trackMetadata.getArt().getSources().get(4).getHeightPixels()).longValue(), 600L);
        assertEquals(subject.getId(), "1021012f-12bb-4938-9723-067a4338b6d0");
        assertTrue((boolean) subject.getActions().getPlayable());
        assertFalse((boolean) subject.getActions().getBrowsable());
        // assertFalse((boolean) subject.getActions().getBrowseable());
    }
}