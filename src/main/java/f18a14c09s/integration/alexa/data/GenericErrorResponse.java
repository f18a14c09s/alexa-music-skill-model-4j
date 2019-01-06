package f18a14c09s.integration.alexa.data;

public class GenericErrorResponse extends AbstractErrorResponse<AbstractErrorResponse.Payload> {
    public GenericErrorResponse() {
        this(null);
    }

    public GenericErrorResponse(String messageId) {
        MessageHeader header = new MessageHeader();
        header.setNamespace("Alexa.Media");
        header.setName("ErrorResponse");
        header.setPayloadVersion("1.0");
        header.setMessageId(messageId);
        setHeader(header);
    }
}
