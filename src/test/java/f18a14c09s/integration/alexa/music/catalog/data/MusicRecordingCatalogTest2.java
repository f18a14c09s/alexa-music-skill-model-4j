package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MusicRecordingCatalogTest2 {
    public static final String TEST_CASE =
            "{\"type\":\"AMAZON.MusicRecording\",\"version\":2.0,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"entities\":[{\"id\":\"707c2502-21f8-3436-97e9-2c276c981160\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.086Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Higher Ground\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"685e91c5-39e9-360b-bd6d-50667c95b47a\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.110Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Fight Like A Brave\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"274a8f85-3e15-30bf-a869-baa3e9d6c198\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.140Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Behind The Sun\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"314d23ee-b47a-3837-8189-223cc7c71a53\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.160Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Me & My Friends\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"4cb2012c-1e86-300b-8143-1fc05569eae3\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.179Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Backwoods\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"01493a84-e412-33ed-b725-3b40596ac210\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.203Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"True Men Don't Kill Coyotes\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"bd2b7e5f-85a6-3a65-865c-4ebc6d7c95bb\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.215Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Fire\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"aca8b783-bc2a-3ce3-8528-e50fe8fb2384\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.234Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Get Up And Jump\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"5d404906-5ce0-3578-a4aa-15b8682ef32c\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.258Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Knock Me Down\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"a8893ad3-2506-3ede-8244-ff9dad1a9052\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.285Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Under The Bridge\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"5ffe3610-2303-3468-bd5d-23508673b5d3\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.312Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Show Me Your Soul\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"15645cda-88f7-3639-8e4d-b1111fc0fcdb\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.336Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"If You Want Me To Stay\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"1ac44103-6f92-3b98-95ba-1137464ee064\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.367Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Hollywood\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"6f561d36-392f-3aa4-82a0-3a6ed3e4ef51\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.392Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Jungle Man\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"55b8911f-ec89-31b9-8488-a09fa4200c74\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.414Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"The Brothers Cup\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"470ec0ba-c5cb-3d4c-b9d1-ee4a7fa29c23\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.442Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Taste The Pain\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"4fe3a3b0-7164-33d2-b67d-8cbfa4e8c4a5\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.453Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Catholic School Girls Rule\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]},{\"id\":\"959d5dda-6620-3755-b770-c4aa0e36c05c\",\"lastUpdatedTime\":\"2018-12-15T02:51:59.483Z\",\"deleted\":false,\"locales\":[{\"country\":\"US\",\"language\":\"en\"}],\"names\":[{\"language\":\"en\",\"value\":\"Johnny Kick A Hole In The Sky\"}],\"popularity\":{\"overrides\":null,\"default\":0},\"alternateNames\":null,\"languageOfContent\":[\"en\"],\"artists\":[{\"id\":\"8780f1b8-319c-35a6-9180-ce25a0fd4f73\",\"names\":[{\"language\":\"en\",\"value\":\"Red Hot Chili Peppers\"}],\"alternateNames\":null}],\"albums\":[{\"id\":\"7545acd8-ec76-3d8a-9454-649c585c51c4\",\"names\":[{\"language\":\"en\",\"value\":\"What Hits!?\"}],\"alternateNames\":null,\"releaseType\":\"Studio Recording\"}]}]}";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        MusicRecordingCatalog subject = jsonMapper.readValue(TEST_CASE, MusicRecordingCatalog.class);
        assertEquals(jsonMapper.readValue(TEST_CASE, HashMap.class),
                jsonMapper.readValue(jsonMapper.writeValueAsString(subject), HashMap.class));
    }
}