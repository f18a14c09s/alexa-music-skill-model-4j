package f18a14c09s.integration.alexa.music;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import f18a14c09s.integration.alexa.UnknownMessageTypeException;
import f18a14c09s.integration.alexa.data.GenericErrorResponse;
import f18a14c09s.integration.alexa.music.data.RequestType;
import f18a14c09s.integration.alexa.music.messagetypes.*;

import java.io.IOException;
import java.util.*;

import static f18a14c09s.integration.alexa.music.messagetypes.AlexaAudioPlayQueue.*;
import static f18a14c09s.integration.alexa.music.messagetypes.AlexaMediaPlayback.INITIATE_RESPONSE;
import static f18a14c09s.integration.alexa.music.messagetypes.AlexaMediaSearch.GET_PLAYABLE_CONTENT_RESPONSE;

public class ResponseDeserializer extends StdDeserializer<Response> {
    private static final Map<RequestType, Class<? extends Response<?>>> types;

    static {
        Map<RequestType, Class<? extends Response<?>>> tempMap = new HashMap<>();
        tempMap.put(new RequestType(AlexaMediaSearch.NAMESPACE_NAME, GET_PLAYABLE_CONTENT_RESPONSE.getMyName()),
                GetPlayableContentResponse.class);
        tempMap.put(new RequestType(AlexaMediaPlayback.NAMESPACE_NAME, INITIATE_RESPONSE.getMyName()),
                InitiateResponse.class);
        tempMap.put(new RequestType(AlexaAudioPlayQueue.NAMESPACE_NAME, GET_ITEM_RESPONSE.getMyName()),
                GetItemResponse.class);
        tempMap.put(new RequestType(AlexaAudioPlayQueue.NAMESPACE_NAME, GET_PREVIOUS_ITEM_RESPONSE.getMyName()),
                GetPreviousItemResponse.class);
        tempMap.put(new RequestType(AlexaAudioPlayQueue.NAMESPACE_NAME, GET_NEXT_ITEM_RESPONSE.getMyName()),
                GetNextItemResponse.class);
        tempMap.put(new RequestType(AlexaAudioPlayQueue.NAMESPACE_NAME, GET_VIEW_RESPONSE.getMyName()),
                GetViewResponse.class);
        tempMap.put(new RequestType("Alexa", "ErrorResponse"), GenericErrorResponse.class);
        tempMap.put(new RequestType("Alexa.Media", "ErrorResponse"), MediaErrorResponse.class);
        tempMap.put(new RequestType("Alexa.Audio", "ErrorResponse"), AudioErrorResponse.class);
        tempMap.put(new RequestType("Alexa", "Response"), GenericResponse.class);
        types = Collections.unmodifiableMap(tempMap);
    }

    protected ResponseDeserializer() {
        super((Class<?>) null);
    }

    @Override
    public Response deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode object = p.getCodec().readTree(p);
        Optional<JsonNode> header = Optional.ofNullable(object.get("header"));
        Optional<String> namespace = header.map(hdr -> hdr.get("namespace")).map(JsonNode::asText);
        Optional<String> name = header.map(hdr -> hdr.get("name")).map(JsonNode::asText);
        Optional<Class<? extends Response<?>>> clazz =
                namespace.flatMap(ns -> name.map(n -> new RequestType(ns, n))).map(types::get);
        return p.getCodec()
                .treeToValue(object,
                        clazz.orElseThrow(() -> new UnknownMessageTypeException(Response.class,
                                namespace.orElse(null),
                                name.orElse(null))));
    }
}
