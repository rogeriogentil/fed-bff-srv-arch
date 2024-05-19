package rogeriogentil.srv.sample.infrastructure.repository.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;
import rogeriogentil.srv.sample.infrastructure.repository.entity.ToggleEntity;
import rogeriogentil.srv.sample.infrastructure.repository.mapper.JpaToggleMapper;
import rogeriogentil.srv.sample.infrastructure.repository.persistence.JpaToggleRepository;

import java.util.List;

public class JpaToggleGateway implements ToggleGateway {

    @Autowired
    private JpaToggleRepository repository;

    @Override
    public List<Toggle> findAll() {
        List<ToggleEntity> toggleEntities = repository.findAll();
        List<Toggle> toggles = JpaToggleMapper.INSTANCE.toModels(toggleEntities);
        return toggles;
    }
}
