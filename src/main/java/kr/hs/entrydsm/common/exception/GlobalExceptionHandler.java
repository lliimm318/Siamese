package kr.hs.entrydsm.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ServiceException> handleRequestException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ServiceException(HttpStatus.BAD_REQUEST.value(), "Invalid Parameters"),
                                    HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<ServiceException> handleServiceException(ServiceException e) {
        return new ResponseEntity<>(e, e.getHttpStatus());
    }
}
