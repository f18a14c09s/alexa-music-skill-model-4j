package f18a14c09s.integration.alexa.music.data.new1;

public enum MessageNamespace {

    Alexa_Media_PlayQueue("Alexa.Media.PlayQueue", AlexaMediaPlayQueueMessageName.class);

    private String actualName;

    private Class<? extends Enum> names;


    MessageNamespace(String actualName, Class<? extends Enum> names) {
        this.actualName = actualName;
        this.names = names;
    }


    public static MessageNamespace valueOfFromActualName(String name) {
        for (MessageNamespace candidate : MessageNamespace.values()) {
            if (candidate.actualName.equals(name)) {
                return candidate;
            }
        }
        throw new IllegalArgumentException(
                "No enum constant " + MessageNamespace.class.getCanonicalName() + " with actual name " + name + ".");
    }

}
