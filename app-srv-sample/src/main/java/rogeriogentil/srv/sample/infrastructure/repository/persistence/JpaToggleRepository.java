package rogeriogentil.srv.sample.infrastructure.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rogeriogentil.srv.sample.infrastructure.repository.entity.ToggleEntity;

import java.util.Optional;

public interface JpaToggleRepository extends JpaRepository<ToggleEntity, Long> {

    Optional<ToggleEntity> findByKeyName(String key);

    @Transactional
    @Modifying
    @Query("UPDATE ToggleEntity t SET t.enabled = :enabled WHERE t.keyName = :keyName")
    void updateByKeyName(@Param("keyName") String key, @Param("enabled") boolean enabled);
}
