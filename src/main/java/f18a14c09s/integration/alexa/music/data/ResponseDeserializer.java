package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import f18a14c09s.integration.alexa.data.GenericErrorResponse;
import f18a14c09s.integration.alexa.data.ResponseMap;

import java.io.IOException;
import java.util.*;

public class ResponseDeserializer extends StdDeserializer<Response> {
    private static final Map<MusicRequestType, Class<? extends Response<?>>> types;

    static {
        Map<MusicRequestType, Class<? extends Response<?>>> tempMap = new HashMap<>();
        tempMap.put(new MusicRequestType("Alexa.Media.Search", "GetPlayableContent.Response"),
                GetPlayableContentResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Media.Playback", "Initiate.Response"), InitiateResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Audio.PlayQueue", "GetItem.Response"), GetItemResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Audio.PlayQueue", "GetPreviousItem.Response"),
                GetPreviousItemResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Audio.PlayQueue", "GetNextItem.Response"), GetNextItemResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Audio.PlayQueue", "GetView.Response"), GetViewResponse.class);
        tempMap.put(new MusicRequestType("Alexa", "ErrorResponse"), GenericErrorResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Media", "ErrorResponse"), MediaErrorResponse.class);
        tempMap.put(new MusicRequestType("Alexa.Audio", "ErrorResponse"), AudioErrorResponse.class);
        types = Collections.unmodifiableMap(tempMap);
    }

    protected ResponseDeserializer() {
        super((Class<?>) null);
    }

    @Override
    public Response deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode object = p.getCodec().readTree(p);
        Optional<JsonNode> header = Optional.ofNullable(object.get("header"));
        Optional<String> namespace = header.map(hdr -> hdr.get("namespace")).map(JsonNode::asText);
        Optional<String> name = header.map(hdr -> hdr.get("name")).map(JsonNode::asText);
        Optional<Class<? extends Response<?>>> clazz =
                namespace.flatMap(ns -> name.map(n -> new MusicRequestType(ns, n))).map(types::get);
        return p.getCodec().treeToValue(object, clazz.orElse(ResponseMap.class));
    }
}
