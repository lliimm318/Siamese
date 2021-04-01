package kr.hs.entrydsm.common.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class TokenTypeInvalidException extends ServiceException {
    public TokenTypeInvalidException() { super(HttpStatus.UNAUTHORIZED.value(), "Invalid type of token"); }
}
