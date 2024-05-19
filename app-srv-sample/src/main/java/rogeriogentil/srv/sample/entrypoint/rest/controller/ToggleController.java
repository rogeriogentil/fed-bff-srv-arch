package rogeriogentil.srv.sample.entrypoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.usecase.FindAllTogglesUseCase;
import rogeriogentil.srv.sample.entrypoint.rest.adapter.DTOToggleMapper;
import rogeriogentil.srv.sample.entrypoint.rest.model.ToggleDTO;

import java.util.List;

@RestController
@RequestMapping("/v1/toggles")
public class ToggleController {

    private FindAllTogglesUseCase findAllTogglesUseCase;

    public ToggleController(FindAllTogglesUseCase findAllTogglesUseCase) {
        this.findAllTogglesUseCase = findAllTogglesUseCase;
    }

    @GetMapping
    public List<ToggleDTO> findAll() {
        List<Toggle> toggles = findAllTogglesUseCase.execute();
        List<ToggleDTO> dtos = DTOToggleMapper.INSTANCE.toDTOs(toggles);
        return dtos;
    }
}
