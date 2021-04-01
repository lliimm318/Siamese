package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class ImageNotFoundException extends ServiceException {
    public ImageNotFoundException() { super(HttpStatus.NOT_FOUND.value(), "Image id is invalid"); }
}
