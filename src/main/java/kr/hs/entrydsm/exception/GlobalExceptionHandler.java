package kr.hs.entrydsm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleRequestException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("Invalid Parameters", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<Object> handleServiceException(ServiceException e) {
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
}
