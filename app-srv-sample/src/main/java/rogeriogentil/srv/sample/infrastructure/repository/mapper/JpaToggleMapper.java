package rogeriogentil.srv.sample.infrastructure.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.domain.ToggleEnum;
import rogeriogentil.srv.sample.infrastructure.repository.entity.ToggleEntity;

import java.util.List;

@Mapper
public interface JpaToggleMapper {

    JpaToggleMapper INSTANCE = Mappers.getMapper(JpaToggleMapper.class);

    @Mapping(source = "keyName", target = "toggle", qualifiedByName = "keyNameToEnum")
    Toggle toModel(ToggleEntity entity);

    @Mapping(source = "keyName", target = "toggle", qualifiedByName = "keyNameToEnum")
    List<Toggle> toModels(List<ToggleEntity> toggleEntities);

    @Named("keyNameToEnum")
    default ToggleEnum keyNameToEnum(String keyName) {
        return ToggleEnum.valueOf(keyName.toUpperCase());
    }
}
