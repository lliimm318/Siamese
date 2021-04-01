package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ServiceException {
    public ForbiddenException() { super(HttpStatus.FORBIDDEN.value(), "Forbidden (Invalid access)"); }
}
