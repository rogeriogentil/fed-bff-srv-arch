package rogeriogentil.srv.sample.core.usecase;

import rogeriogentil.srv.sample.core.domain.Toggle;

import java.util.List;

public interface FindAllTogglesUseCase {

    List<Toggle> execute();
}
