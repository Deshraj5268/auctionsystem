package raj.auctionsystem.exception;

public class ApplicationException extends RuntimeException {

    private CustomMessage customMessage;

    public ApplicationException(CustomMessage customMessage) {
        this.customMessage = customMessage;
    }

    public ApplicationException(String message){
        super(message);
    }

    public CustomMessage getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(CustomMessage customMessage) {
        this.customMessage = customMessage;
    }
}
