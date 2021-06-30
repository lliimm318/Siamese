package kr.hs.entrydsm.service.exception;

import kr.hs.entrydsm.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class InvalidPostTypeException extends ServiceException {
    public InvalidPostTypeException() { super(HttpStatus.BAD_REQUEST.value(), "Invalid type of post"); }
}
