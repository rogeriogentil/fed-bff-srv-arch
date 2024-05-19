package rogeriogentil.srv.sample.entrypoint.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToggleDTO {

    private String key;
    private boolean enabled;
}
