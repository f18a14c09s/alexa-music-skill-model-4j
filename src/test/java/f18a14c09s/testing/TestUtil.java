package f18a14c09s.testing;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtil {
    public static <T> T assertInstanceOfAndCast(Object object, Class<T> targetClass) {
        assertTrue(object != null && targetClass.isAssignableFrom(object.getClass()),
                object == null ?
                        "Object is null." :
                        String.format("Object %s not instance of %s.  Actual type: %s.",
                                object,
                                targetClass.getName(),
                                object.getClass().getName()));
        return (T) object;
    }
}
