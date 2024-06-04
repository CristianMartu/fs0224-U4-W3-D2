package cristianmartucci.exceptions;

public class EventException extends RuntimeException {
    public EventException(long eventId) {
        super("Nessun evento trovato con id: " + eventId);
    }
}
