package kr.hs.entrydsm.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ServiceException {
    public BadRequestException() { super(HttpStatus.BAD_REQUEST.value(), "Bad request"); }
}
