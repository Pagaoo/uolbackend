package gabriel.dev.uolbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleGlobalException(Exception exception) {
        ExceptionDto exceptionDto = new ExceptionDto("Erro interno do Servidor", "500");
        return ResponseEntity.internalServerError().body(String.valueOf(exceptionDto));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noCodinameAvailable(NoSuchElementException exception) {
        ExceptionDto exceptionDto = new ExceptionDto("Não há mais codinomes disponiveis nesta Lista", "400");
        return ResponseEntity.badRequest().body(exceptionDto);
    }

}
