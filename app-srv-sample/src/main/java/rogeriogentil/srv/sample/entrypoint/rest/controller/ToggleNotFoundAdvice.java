package rogeriogentil.srv.sample.entrypoint.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rogeriogentil.srv.sample.core.exception.ToggleNotFoundException;
import rogeriogentil.srv.sample.entrypoint.rest.model.NotFoundDTO;

@RestControllerAdvice
public class ToggleNotFoundAdvice {

    @ExceptionHandler(ToggleNotFoundException.class)
    ResponseEntity<NotFoundDTO> toggleNotFoundHandler(ToggleNotFoundException tnfe) {
        NotFoundDTO notFoundDTO = NotFoundDTO.builder()
                .status(HttpStatus.NOT_FOUND.toString())
                .message(tnfe.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundDTO);
    }
}
