package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends ServiceException {
    public PostNotFoundException() { super(HttpStatus.NOT_FOUND.value(), "Post not found"); }
}
