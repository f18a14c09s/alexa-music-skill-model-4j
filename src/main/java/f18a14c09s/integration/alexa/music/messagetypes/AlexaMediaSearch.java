package f18a14c09s.integration.alexa.music.messagetypes;

import lombok.Getter;

public enum AlexaMediaSearch {
    GET_PLAYABLE_CONTENT("GetPlayableContent"),
    GET_PLAYABLE_CONTENT_RESPONSE("GetPlayableContent.Response");
    @Getter
    private final String myName;

    public static final String NAMESPACE_NAME = "Alexa.Media.Search";

    AlexaMediaSearch(String myName) {
        this.myName = myName;
    }
}
