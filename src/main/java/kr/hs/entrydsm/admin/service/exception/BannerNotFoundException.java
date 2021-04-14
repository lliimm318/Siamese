package kr.hs.entrydsm.admin.service.exception;

import kr.hs.entrydsm.common.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class BannerNotFoundException extends ServiceException {
    public BannerNotFoundException() { super(HttpStatus.NOT_FOUND.value(), "Banner not found"); }
}
