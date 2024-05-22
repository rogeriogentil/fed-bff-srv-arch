package rogeriogentil.srv.sample.core.usecase;

import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.exception.ToggleNotFoundException;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;

public class ToggleFeatureByKeyUseCaseImpl implements ToggleFeatureByKeyUseCase {

    private final FindToggleByKeyUseCase findToggleByKeyUseCase;
    private final ToggleGateway toggleGateway;

    public ToggleFeatureByKeyUseCaseImpl(FindToggleByKeyUseCase findToggleByKeyUseCase,
                                         ToggleGateway toggleGateway) {
        this.findToggleByKeyUseCase = findToggleByKeyUseCase;
        this.toggleGateway = toggleGateway;
    }

    @Override
    public Toggle execute(String key) throws ToggleNotFoundException {
        Toggle toggle = findToggleByKeyUseCase.execute(key);
        toggle.setEnabled(!toggle.isEnabled());
        toggleGateway.toggleByKey(toggle.getToggle().getKey(), toggle.isEnabled());
        return toggle;
    }
}
