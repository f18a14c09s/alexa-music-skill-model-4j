package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MediaReferenceTest1 {
    public static final String TEST_CASE =
            "{   \"namespace\": \"Alexa.Audio.PlayQueue\",   \"name\": \"item\",   \"value\": {     \"id\": \"e73befbe-8c27-4e4b-ab0c-9865ce8516f0\",     \"queueId\": \"76f325d5-a648-4e8f-87ad-6e53cf99e4c7\",     \"contentId\": \"1021012f-12bb-4938-9723-067a4338b6d0\"   } }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ItemMediaReference subject = jsonMapper.readValue(TEST_CASE, ItemMediaReference.class);
        assertEquals(subject.getNamespace(), "Alexa.Audio.PlayQueue");
        assertEquals(subject.getName(), "item");
        assertEquals(subject.getValue().getId(), "e73befbe-8c27-4e4b-ab0c-9865ce8516f0");
        assertEquals(subject.getValue().getQueueId(), "76f325d5-a648-4e8f-87ad-6e53cf99e4c7");
        assertEquals(subject.getValue().getContentId(), "1021012f-12bb-4938-9723-067a4338b6d0");
    }

    public static final class ItemMediaReference extends MediaReference<ItemReference> {
    }
}