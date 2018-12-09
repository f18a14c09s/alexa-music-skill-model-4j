package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import f18a14c09s.integration.alexa.data.RequestMap;

import java.io.IOException;
import java.util.*;

public class RequestDeserializer extends StdDeserializer<Request> {
    private static final Map<MusicRequestType, Class<? extends Request<?>>> types;

    static {
        Map<MusicRequestType, Class<? extends Request<?>>> tempMap = new HashMap<>();
        tempMap.put(new MusicRequestType("Alexa.Media.Search", "GetPlayableContent"), GetPlayableContentRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Media.Playback", "Initiate"), InitiateRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Media.PlayQueue", "GetItem"), GetItemRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Audio.PlayQueue", "GetPreviousItem"), GetPreviousItemRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Audio.PlayQueue", "GetNextItem"), GetNextItemRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Media.PlayQueue", "GetView"), GetViewRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Media.PlayQueue", "SetLoop"), SetLoopRequest.class);
        tempMap.put(new MusicRequestType("Alexa.Media.PlayQueue", "SetShuffle"), SetShuffleRequest.class);
        types = Collections.unmodifiableMap(tempMap);
    }

    protected RequestDeserializer() {
        super((Class<?>) null);
    }

    @Override
    public Request deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode object = p.getCodec().readTree(p);
        Optional<JsonNode> header = Optional.ofNullable(object.get("header"));
        Optional<String> namespace = header.map(hdr -> hdr.get("namespace")).map(JsonNode::asText);
        Optional<String> name = header.map(hdr -> hdr.get("name")).map(JsonNode::asText);
        Optional<Class<? extends Request<?>>> clazz =
                namespace.flatMap(ns -> name.map(n -> new MusicRequestType(ns, n))).map(types::get);
        return p.getCodec().treeToValue(object, clazz.orElse(RequestMap.class));
    }
}
