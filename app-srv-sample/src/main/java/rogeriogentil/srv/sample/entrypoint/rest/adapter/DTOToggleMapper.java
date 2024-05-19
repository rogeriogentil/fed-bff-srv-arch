package rogeriogentil.srv.sample.entrypoint.rest.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.domain.ToggleEnum;
import rogeriogentil.srv.sample.entrypoint.rest.model.ToggleDTO;

import java.util.List;

@Mapper
public interface DTOToggleMapper {

    DTOToggleMapper INSTANCE = Mappers.getMapper(DTOToggleMapper.class);

    @Mapping(source = "toggle", target = "key", qualifiedByName = "enumToSring")
    ToggleDTO toDTO(Toggle toggle);

    @Mapping(source = "toggle", target = "key", qualifiedByName = "enumToSring")
    List<ToggleDTO> toDTOs(List<Toggle> toggles);

    @Named("enumToSring")
    default String enumToString(ToggleEnum toggle) {
        return toggle.name();
    }
}
