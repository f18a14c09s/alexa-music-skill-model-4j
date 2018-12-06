package f18a14c09s.integration.alexa.music;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ExampleMessageTest {

    public static final String TEST_CASE =
            "{\"message\": \"Hello, World!\",\"myInt\": 123,\"myDouble\": 123.456,\"myBoolean\": false,\"myArray\": [1, 2, 3],\"myObject\": {\"otherMessage\": \"My Other Message\"},\"nullValue\": null}";


    @Test
    void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ExampleMessage subject = mapper.readValue(TEST_CASE, ExampleMessage.class);
        subTest(subject, (ExampleMessage o0) -> {
            assertEquals((Double)o0.getMyDouble(),(Double) 123.456);
            subTest(o0.getMyArray(), o1 -> {
                List<?> list1 = (List<?>) o1;
                assertEquals(list1.get(0), 1);
                assertEquals(list1.get(1), 2);
                assertEquals(list1.get(2), 3);
            });
            assertEquals((Boolean)o0.getMyBoolean(), false);
            assertEquals((Integer)o0.getMyInt(), (Integer)123);
            assertEquals(o0.getMessage(), "Hello, World!");
            subTest(o0.getMyObject(), o1 -> {
                assertEquals(o1.getOtherMessage(), "My Other Message");
            });
            assertNull(o0.getNullValue());
        });
    }


    private <T> void subTest(T o, Consumer<T> test) {
        test.accept(o);
    }
}
