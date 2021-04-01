package kr.hs.entrydsm.common.exception;

import org.springframework.http.HttpStatus;

public class TokenInvalidException extends ServiceException {
    public TokenInvalidException() { super(HttpStatus.UNAUTHORIZED.value(), "Token is invalid"); }
}
