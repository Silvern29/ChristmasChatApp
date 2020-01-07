package at.redlinghaus.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {
    public EmailExistsException(final String message) {
        super(message);
    }
}
