package rogeriogentil.srv.sample.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "feature_toggle")
public class ToggleEntity {

    @Id
    @GeneratedValue
    private long id;
    private String keyName;
    private boolean enabled;
}
