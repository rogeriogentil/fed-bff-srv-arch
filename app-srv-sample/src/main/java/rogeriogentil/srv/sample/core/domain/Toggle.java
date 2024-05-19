package rogeriogentil.srv.sample.core.domain;

import lombok.Data;

@Data
public class Toggle {

    private ToggleEnum toggle;
    private boolean enabled;
}
