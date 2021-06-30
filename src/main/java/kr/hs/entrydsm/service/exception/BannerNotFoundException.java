package kr.hs.entrydsm.service.exception;

import kr.hs.entrydsm.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class BannerNotFoundException extends ServiceException {
    public BannerNotFoundException() { super(HttpStatus.NOT_FOUND.value(), "Banner not found"); }
}
