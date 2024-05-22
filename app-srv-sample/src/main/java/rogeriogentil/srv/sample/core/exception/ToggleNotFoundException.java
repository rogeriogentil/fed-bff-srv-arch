package rogeriogentil.srv.sample.core.exception;

public class ToggleNotFoundException extends Exception {

    public ToggleNotFoundException(String key) {
        super("Could not find feature toggle " + key);
    }
}
