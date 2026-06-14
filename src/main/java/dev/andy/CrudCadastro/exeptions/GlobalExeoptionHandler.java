package dev.andy.CrudCadastro.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExeoptionHandler {


          @ExceptionHandler(NotFoundEmail.class)
          public ResponseEntity<String> EmailNotFound(NotFoundEmail exception) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
}

}
