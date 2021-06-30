package kr.hs.entrydsm.exception;

import org.springframework.http.HttpStatus;

public class TokenTypeInvalidException extends ServiceException {
    public TokenTypeInvalidException() { super(HttpStatus.UNAUTHORIZED.value(), "Invalid type of token"); }
}
