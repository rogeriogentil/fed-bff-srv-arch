package rogeriogentil.srv.sample.core.usecase;

import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;

import java.util.List;

public class FindAllTogglesUseCaseImpl implements FindAllTogglesUseCase {

    private final ToggleGateway toggleGateway;

    public FindAllTogglesUseCaseImpl(ToggleGateway toggleGateway) {
        this.toggleGateway = toggleGateway;
    }

    @Override
    public List<Toggle> execute() {
        return toggleGateway.findAll();
    }
}
