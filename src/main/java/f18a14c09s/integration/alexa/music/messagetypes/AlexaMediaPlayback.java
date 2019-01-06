package f18a14c09s.integration.alexa.music.messagetypes;

import lombok.Getter;

public enum AlexaMediaPlayback {
    INITIATE("Initiate"),
    INITIATE_RESPONSE("Initiate.Response");
    @Getter
    private final String myName;

    public static final String NAMESPACE_NAME = "Alexa.Media.Playback";

    AlexaMediaPlayback(String myName) {
        this.myName = myName;
    }
}
