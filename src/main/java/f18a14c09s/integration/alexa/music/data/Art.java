package f18a14c09s.integration.alexa.music.data;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Art {
    private String contentDescription;
    private ArrayList<Source> sources;

    @Getter
    @Setter
    public static final class Source {
        private String url;
        private String size;
        private Long widthPixels;
        private Long heightPixels;
    }
}
