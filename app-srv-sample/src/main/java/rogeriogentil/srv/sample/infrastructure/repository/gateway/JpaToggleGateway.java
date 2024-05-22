package rogeriogentil.srv.sample.infrastructure.repository.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;
import rogeriogentil.srv.sample.infrastructure.repository.entity.ToggleEntity;
import rogeriogentil.srv.sample.infrastructure.repository.mapper.JpaToggleMapper;
import rogeriogentil.srv.sample.infrastructure.repository.persistence.JpaToggleRepository;

import java.util.List;
import java.util.Optional;

public class JpaToggleGateway implements ToggleGateway {

    @Autowired
    private JpaToggleRepository repository;

    @Override
    public List<Toggle> findAll() {
        List<ToggleEntity> toggleEntities = repository.findAll();
        return JpaToggleMapper.INSTANCE.toModels(toggleEntities);
    }

    @Override
    public Optional<Toggle> findByKey(String key) {
        Optional<ToggleEntity> toggleEntity = repository.findByKeyName(key);
        if (toggleEntity.isPresent()) {
            Toggle toggle = JpaToggleMapper.INSTANCE.toModel(toggleEntity.get());
            return Optional.of(toggle);
        }
        return Optional.empty();
    }

    @Override
    public void toggleByKey(String key, boolean enabled) {
        repository.updateByKeyName(key, enabled);
    }
}
