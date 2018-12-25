package f18a14c09s.integration.alexa.music.messagetypes;

import lombok.Getter;

public enum AlexaMediaPlayQueue {
    GET_ITEM("GetItem"),
    //    GET_ITEM_RESPONSE("GetItem.Response"),
//    GET_PREVIOUS_ITEM("GetPreviousItem"),
//    GET_PREVIOUS_ITEM_RESPONSE("GetPreviousItem.Response"),
//    GET_NEXT_ITEM("GetNextItem"),
//    GET_NEXT_ITEM_RESPONSE("GetNextItem.Response"),
    GET_VIEW("GetView"),
    //    GET_VIEW_RESPONSE("GetView.Response"),
    SET_LOOP("SetLoop"),
    SET_LOOP_RESPONSE("SetLoop.Response"),
    SET_SHUFFLE("SetShuffle"),
    SET_SHUFFLE_RESPONSE("SetShuffle.Response");
    @Getter
    private final String myName;

    public static final String NAMESPACE_NAME = "Alexa.Media.PlayQueue";

    AlexaMediaPlayQueue(String myName) {
        this.myName = myName;
    }
}
