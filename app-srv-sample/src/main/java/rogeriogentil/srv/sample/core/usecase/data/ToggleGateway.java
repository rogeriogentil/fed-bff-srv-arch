package rogeriogentil.srv.sample.core.usecase.data;

import rogeriogentil.srv.sample.core.domain.Toggle;

import java.util.List;

public interface ToggleGateway {

    List<Toggle> findAll();
 }
