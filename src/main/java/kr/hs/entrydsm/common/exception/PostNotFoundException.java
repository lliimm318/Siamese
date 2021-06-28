package kr.hs.entrydsm.common.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends ServiceException {
    public PostNotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), "PostException");
    }
}
