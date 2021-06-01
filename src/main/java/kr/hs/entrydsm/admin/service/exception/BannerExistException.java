package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class BannerExistException extends ServiceException {
    public BannerExistException() { super(HttpStatus.CONFLICT.value(), "Image already exist"); }
}
