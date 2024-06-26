package rogeriogentil.srv.sample.entrypoint.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rogeriogentil.srv.sample.core.domain.Toggle;
import rogeriogentil.srv.sample.core.exception.ToggleNotFoundException;
import rogeriogentil.srv.sample.core.usecase.FindAllTogglesUseCase;
import rogeriogentil.srv.sample.core.usecase.FindToggleByKeyUseCase;
import rogeriogentil.srv.sample.core.usecase.ToggleFeatureByKeyUseCase;
import rogeriogentil.srv.sample.entrypoint.rest.adapter.DTOToggleMapper;
import rogeriogentil.srv.sample.entrypoint.rest.model.ToggleDTO;

import java.util.List;

@RestController
@RequestMapping("/v1/toggles")
public class ToggleController {

    private final FindAllTogglesUseCase findAllTogglesUseCase;
    private final FindToggleByKeyUseCase findToggleByKeyUseCase;
    private final ToggleFeatureByKeyUseCase toggleFeatureByKeyUseCase;

    public ToggleController(FindAllTogglesUseCase findAllTogglesUseCase,
                            FindToggleByKeyUseCase findToggleByKeyUseCase,
                            ToggleFeatureByKeyUseCase toggleFeatureByKeyUseCase) {
        this.findAllTogglesUseCase = findAllTogglesUseCase;
        this.findToggleByKeyUseCase = findToggleByKeyUseCase;
        this.toggleFeatureByKeyUseCase = toggleFeatureByKeyUseCase;
    }

    @GetMapping
    public List<ToggleDTO> findAll() {
        List<Toggle> toggles = findAllTogglesUseCase.execute();
        return DTOToggleMapper.INSTANCE.toDTOs(toggles);
    }

    @GetMapping("/{key}")
    public ResponseEntity<ToggleDTO> findByKey(@PathVariable String key) throws ToggleNotFoundException {
        Toggle toggle = findToggleByKeyUseCase.execute(key);
        ToggleDTO toggleDTO = DTOToggleMapper.INSTANCE.toDTO(toggle);
        return ResponseEntity.ok(toggleDTO);
    }

    @PatchMapping("/{key}/toggle")
    public ResponseEntity<ToggleDTO> toggleByKey(@PathVariable String key) throws ToggleNotFoundException {
        Toggle toggle = toggleFeatureByKeyUseCase.execute(key);
        ToggleDTO toggleDTO = DTOToggleMapper.INSTANCE.toDTO(toggle);
        return ResponseEntity.ok(toggleDTO);
    }
}
