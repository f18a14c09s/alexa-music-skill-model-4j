package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

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

        assertEquals(subject.getAttributes().get(0).getType(), "GENRE");
//        assertEquals(subject.getAttributes().get(0).getEntityId(), "G1");
        assertEquals(subject.getAttributes().get(1).getType(), "ARTIST");
//        assertEquals(subject.getAttributes().get(1).getEntityId(), "A2");
        assertEquals(subject.getAttributes().get(2).getType(), "MEDIA_TYPE");
//        assertEquals(subject.getAttributes().get(2).getValue(), "TRACK");
        assertEquals(subject.getRawSelectionCriteriaId(), "e7f74c2c-eec7-452c-ad53-7f82509232c8");
    }
}