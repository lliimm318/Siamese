package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class InvalidPostTypeException extends ServiceException {
    public InvalidPostTypeException() { super(HttpStatus.BAD_REQUEST.value(), "Invalid type of post"); }
}
