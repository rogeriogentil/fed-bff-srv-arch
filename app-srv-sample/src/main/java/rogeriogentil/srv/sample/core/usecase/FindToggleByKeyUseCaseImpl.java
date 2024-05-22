package rogeriogentil.srv.sample.core.usecase;

import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.exception.ToggleNotFoundException;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;

import java.util.Optional;

public class FindToggleByKeyUseCaseImpl implements FindToggleByKeyUseCase {

    private final ToggleGateway toggleGateway;

    public FindToggleByKeyUseCaseImpl(ToggleGateway toggleGateway) {
        this.toggleGateway = toggleGateway;
    }

    @Override
    public Toggle execute(String key) throws ToggleNotFoundException {
        Optional<Toggle> optionalToggle = toggleGateway.findByKey(key);
        if (optionalToggle.isPresent()) {
            return optionalToggle.get();
        }
        throw new ToggleNotFoundException(key);
    }
}
