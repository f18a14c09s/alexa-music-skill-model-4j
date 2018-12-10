package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.alexa.music.playback.data.PlaybackInfo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.music.playback.data.PlaybackInfoType.DEFAULT;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class PlaybackInfoTest1 {
    public static final String TEST_CASE = "{   \"type\": \"DEFAULT\" }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        PlaybackInfo subject = jsonMapper.readValue(TEST_CASE, PlaybackInfo.class);
        assertEquals(subject.getType(), DEFAULT);
    }
}