package raj.auctionsystem.exception;

public class CustomMessage {

    private String messageCode;
    private String errorMessage;

    public CustomMessage(String messageCode, String errorMessage) {
        this.messageCode = messageCode;
        this.errorMessage = errorMessage;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
