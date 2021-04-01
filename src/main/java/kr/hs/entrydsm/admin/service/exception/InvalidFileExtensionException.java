package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class InvalidFileExtensionException extends ServiceException {
    public InvalidFileExtensionException() { super(HttpStatus.BAD_REQUEST.value(), "Invalid file extension"); }
}
