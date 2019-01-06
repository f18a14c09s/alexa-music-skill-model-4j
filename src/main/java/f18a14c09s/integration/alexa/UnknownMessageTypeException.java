package f18a14c09s.integration.alexa;

import com.fasterxml.jackson.core.JsonProcessingException;

public class UnknownMessageTypeException extends JsonProcessingException {
    public UnknownMessageTypeException(Class<?> api, String namespace, String name) {
        super(String.format("Unsupported %s type: Namespace: %s, Name: %s.", api.getSimpleName(), namespace, name));
    }
}