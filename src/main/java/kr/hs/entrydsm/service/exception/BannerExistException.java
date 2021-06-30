package kr.hs.entrydsm.service.exception;

import kr.hs.entrydsm.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class BannerExistException extends ServiceException {
    public BannerExistException() { super(HttpStatus.CONFLICT.value(), "Image already exist"); }
}
