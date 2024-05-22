package rogeriogentil.srv.sample.core.usecase.data;

import rogeriogentil.srv.sample.core.domain.Toggle;

import java.util.List;
import java.util.Optional;

public interface ToggleGateway {

    List<Toggle> findAll();

    Optional<Toggle> findByKey(String key);

    void toggleByKey(String key, boolean enabled);
 }
