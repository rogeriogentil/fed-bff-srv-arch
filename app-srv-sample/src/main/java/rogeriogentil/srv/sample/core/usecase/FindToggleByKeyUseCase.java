package rogeriogentil.srv.sample.core.usecase;

import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.exception.ToggleNotFoundException;

public interface FindToggleByKeyUseCase {

    Toggle execute(String key) throws ToggleNotFoundException;
}
