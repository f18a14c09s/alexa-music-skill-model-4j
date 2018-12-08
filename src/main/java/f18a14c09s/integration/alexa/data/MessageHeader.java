package f18a14c09s.integration.alexa.data;

import f18a14c09s.integration.alexa.music.data.MusicRequestType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageHeader {
    private String payloadVersion;
    private String namespace;
    private String name;
    private String messageId;

    public MusicRequestType toMusicRequestType() {
        return new MusicRequestType(getNamespace(), getName());
    }
}
