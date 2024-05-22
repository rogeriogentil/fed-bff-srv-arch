package rogeriogentil.srv.sample.infrastructure.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import rogeriogentil.srv.sample.infrastructure.repository.entity.ToggleEntity;

import java.util.Optional;

public interface JpaToggleRepository extends JpaRepository<ToggleEntity, Long> {

    Optional<ToggleEntity> findByKeyName(String key);
}
