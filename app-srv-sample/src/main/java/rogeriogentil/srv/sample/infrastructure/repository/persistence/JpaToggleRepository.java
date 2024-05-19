package rogeriogentil.srv.sample.infrastructure.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import rogeriogentil.srv.sample.infrastructure.repository.entity.ToggleEntity;

public interface JpaToggleRepository extends JpaRepository<ToggleEntity, Long> {
}
