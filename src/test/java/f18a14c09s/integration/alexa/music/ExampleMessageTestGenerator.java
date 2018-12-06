package f18a14c09s.integration.alexa.music;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static f18a14c09s.integration.alexa.music.ExampleMessageTest.TEST_CASE;

public class ExampleMessageTestGenerator {

    private ObjectMapper jsonMapper = new ObjectMapper();


    public static void main(String... args) throws IOException {
        System.out.printf("%s%n",
                new ExampleMessageTestGenerator().generate(TEST_CASE));
    }


    public String generate(String jsonMessage) throws IOException {
        Object map = jsonMapper.readValue(jsonMessage, HashMap.class);
        return recursivelyGenerate("subject", map, 0);
    }


    private String recursivelyGenerate(String expression, Object value, int level) {
        String primitiveValueString = getPrimitiveValue(value);
        if (value == null) {
            return String.format("%nassertNull(%s);", expression);
        } else if (primitiveValueString != null) {
            // TODO: Ensure that call to assertEquals is not ambiguous for actual primitives.
            return String.format("%nassertEquals(%s, %s);", expression, primitiveValueString);
        } else if (value instanceof Map<?, ?>) {
            Map<?, ?> map = (Map<?, ?>) value;
            return String.format("%nsubTest(%s, o%s -> {%s});",
                    expression, level,
                    map.entrySet()
                            .stream()
                            .map(child -> {
                                String key = (String) child.getKey();
                                return recursivelyGenerate(String.format("o%s.get%s%s()", level,
                                        Character.toUpperCase(key.charAt(0)),
                                        key.substring(1)),
                                        child.getValue(), level + 1);
                            }).collect(Collectors.joining()));
        } else if (value instanceof List<?>) {
            List<?> list = (List<?>) value;
            StringBuilder assertionCode = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                assertionCode.append(recursivelyGenerate(String.format("list%s.get(%s)", level, i),
                        list.get(i),
                        level + 1));
            }
            return String.format("%nsubTest(%s, o%s -> {List<?> list%2$s = (List<?>)o%2$s;%s});",
                    expression, level,
                    assertionCode);
        } else {
            throw new IllegalArgumentException("Not sure how to handle.");
        }
    }


    /**
     * TODO: Add support for Date and Calendar?
     *
     * @param o
     * @return
     */
    private String getPrimitiveValue(Object o) {
        if (o instanceof CharSequence || o instanceof Enum<?>) {
            return String.format("\"%s\"", o);
        } else if (o instanceof Character || o instanceof Number || o instanceof Boolean) {
            return o.toString();
        }
        return null;
    }

}
