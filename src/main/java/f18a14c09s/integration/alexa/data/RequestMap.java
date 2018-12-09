package f18a14c09s.integration.alexa.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import f18a14c09s.integration.alexa.music.data.Request;

import java.util.*;

@JsonDeserialize
public class RequestMap extends Request<HashMap<String, Object>> {
}
