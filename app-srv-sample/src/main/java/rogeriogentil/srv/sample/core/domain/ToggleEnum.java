package rogeriogentil.srv.sample.core.domain;

public enum ToggleEnum {

    FIRST_FEATURE("FIRST_FEATURE");

    private final String key;

    ToggleEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
