package kr.hs.entrydsm.service.exception;

import kr.hs.entrydsm.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class InvalidFileExtensionException extends ServiceException {
    public InvalidFileExtensionException() { super(HttpStatus.BAD_REQUEST.value(), "Invalid file extension"); }
}
