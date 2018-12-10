package f18a14c09s.integration.alexa.music.data;

import static f18a14c09s.integration.alexa.data.SpeechType.PLAIN_TEXT;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import static f18a14c09s.integration.alexa.music.data.EntityType.*;
import static f18a14c09s.testing.TestUtil.assertInstanceOfAndCast;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ResolvedSelectionCriteriaTest1 {
    public static final String TEST_CASE =
            "{   \"rawSelectionCriteriaId\": \"e7f74c2c-eec7-452c-ad53-7f82509232c8\",   \"attributes\": [     {       \"type\": \"GENRE\",       \"entityId\": \"G1\"     },     {       \"type\": \"ARTIST\",       \"entityId\": \"A2\"     },     {       \"type\": \"MEDIA_TYPE\",       \"value\": \"TRACK\"     }   ] }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ResolvedSelectionCriteria subject = jsonMapper.readValue(TEST_CASE, ResolvedSelectionCriteria.class);
        ResolvedSelectionCriteria.BasicEntityAttribute basicEntityAttribute =
                assertInstanceOfAndCast(subject.getAttributes().get(0),
                        ResolvedSelectionCriteria.BasicEntityAttribute.class);
        assertEquals(basicEntityAttribute.getType(), GENRE);
        assertEquals(basicEntityAttribute.getEntityId(), "G1");
        basicEntityAttribute = assertInstanceOfAndCast(subject.getAttributes().get(1),
                ResolvedSelectionCriteria.BasicEntityAttribute.class);
        assertEquals(basicEntityAttribute.getType(), ARTIST);
        assertEquals(basicEntityAttribute.getEntityId(), "A2");
        ResolvedSelectionCriteria.MediaTypeAttribute mediaTypeAttribute =
                assertInstanceOfAndCast(subject.getAttributes().get(2),
                        ResolvedSelectionCriteria.MediaTypeAttribute.class);
        assertEquals(mediaTypeAttribute.getType(), MEDIA_TYPE);
        assertEquals(mediaTypeAttribute.getValue(), ResolvedSelectionCriteria.MediaTypeAttrValue.TRACK);
        assertEquals(subject.getRawSelectionCriteriaId(), "e7f74c2c-eec7-452c-ad53-7f82509232c8");
    }
}