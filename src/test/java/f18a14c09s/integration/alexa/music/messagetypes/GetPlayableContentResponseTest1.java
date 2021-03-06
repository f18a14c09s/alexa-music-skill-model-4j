package f18a14c09s.integration.alexa.music.messagetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.music.metadata.MetadataType;
import f18a14c09s.integration.alexa.music.metadata.TrackMetadata;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;
import static f18a14c09s.integration.alexa.music.data.ArtSourceSize.*;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The following example demonstrates a response that satisfies an example request from a user that said "Alexa, play the song Poker Face by Lady Gaga".
 */
public class GetPlayableContentResponseTest1 {
    public static final String TEST_CASE =
            "{   \"header\": {     \"messageId\": \"2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b\",     \"namespace\": \"Alexa.Media.Search\",     \"name\": \"GetPlayableContent.Response\",     \"payloadVersion\": \"1.0\"   },   \"payload\": {     \"content\": {       \"id\": \"1021012f-12bb-4938-9723-067a4338b6d0\",       \"metadata\": {         \"type\": \"TRACK\",         \"name\": {           \"speech\": {             \"type\": \"PLAIN_TEXT\",             \"text\": \"poker face\"           },           \"display\": \"Poker Face\"         },         \"authors\": [           {             \"name\": {               \"speech\": {                 \"type\": \"PLAIN_TEXT\",                 \"text\": \"lady gaga\"               },               \"display\": \"Lady Gaga\"             }           }         ],         \"art\": {           \"sources\": [             {               \"url\": \"https://example.com/images/cover/48x48-000000-80-0-0.jpg\",               \"size\": \"X_SMALL\",               \"widthPixels\": 48,               \"heightPixels\": 48             },             {               \"url\": \"https://example.com/images/cover/60x60-000000-80-0-0.jpg\",               \"size\": \"SMALL\",               \"widthPixels\": 60,               \"heightPixels\": 60             },             {               \"url\": \"https://example.com/images/cover/110x110-000000-80-0-0.jpg\",               \"size\": \"MEDIUM\",               \"widthPixels\": 110,               \"heightPixels\": 110             },             {               \"url\": \"https://example.com/images/cover/256x256-000000-80-0-0.jpg\",               \"size\": \"LARGE\",               \"widthPixels\": 256,               \"heightPixels\": 256             },             {               \"url\": \"https://example.com/images/cover/600x600-000000-80-0-0.jpg\",               \"size\": \"X_LARGE\",               \"widthPixels\": 600,               \"heightPixels\": 600             }           ]         }       }     }   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Response obj = jsonMapper.readValue(TEST_CASE, Response.class);
        GetPlayableContentResponse subject = assertInstanceOfAndCast(obj, GetPlayableContentResponse.class);
        assertEquals(subject.getPayload().getContent().getId(), "1021012f-12bb-4938-9723-067a4338b6d0");
        TrackMetadata trackMetadata =
                assertInstanceOfAndCast(subject.getPayload().getContent().getMetadata(), TrackMetadata.class);
        assertEquals(trackMetadata.getType(), MetadataType.TRACK);
        assertEquals(trackMetadata.getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getName().getSpeech().getText(), "poker face");
        assertEquals(trackMetadata.getName().getDisplay(), "Poker Face");
        assertEquals(trackMetadata.getAuthors().get(0).getName().getSpeech().getType(), PLAIN_TEXT);
        assertEquals(trackMetadata.getAuthors().get(0).getName().getSpeech().getText(), "lady gaga");
        assertEquals(trackMetadata.getAuthors().get(0).getName().getDisplay(), "Lady Gaga");

        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(0).getUrl(),
                "https://example.com/images/cover/48x48-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(0).getSize(), X_SMALL);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getWidthPixels()).longValue(), 48L);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(0)
                .getHeightPixels()).longValue(), 48L);
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(1).getUrl(),
                "https://example.com/images/cover/60x60-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(1).getSize(), SMALL);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getWidthPixels()).longValue(), 60L);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(1)
                .getHeightPixels()).longValue(), 60L);
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(2).getUrl(),
                "https://example.com/images/cover/110x110-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(2).getSize(), MEDIUM);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getWidthPixels()).longValue(), 110L);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(2)
                .getHeightPixels()).longValue(), 110L);
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(3).getUrl(),
                "https://example.com/images/cover/256x256-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(3).getSize(), LARGE);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getWidthPixels()).longValue(), 256L);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(3)
                .getHeightPixels()).longValue(), 256L);
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(4).getUrl(),
                "https://example.com/images/cover/600x600-000000-80-0-0.jpg");
        assertEquals(subject.getPayload().getContent().getMetadata().getArt().getSources().get(4).getSize(), X_LARGE);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getWidthPixels()).longValue(), 600L);
        assertEquals(((Number) subject.getPayload()
                .getContent()
                .getMetadata()
                .getArt()
                .getSources()
                .get(4)
                .getHeightPixels()).longValue(), 600L);
        assertEquals(subject.getHeader().getMessageId(), "2cae4d53-6bc1-4f8f-aa98-7dd2727ca84b");
        assertEquals(subject.getHeader().getNamespace(), "Alexa.Media.Search");
        assertEquals(subject.getHeader().getName(), "GetPlayableContent.Response");
        assertEquals(subject.getHeader().getPayloadVersion(), "1.0");
    }
}