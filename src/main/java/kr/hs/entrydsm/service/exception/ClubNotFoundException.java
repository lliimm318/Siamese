package kr.hs.entrydsm.service.exception;

import kr.hs.entrydsm.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class ClubNotFoundException extends ServiceException {
    public ClubNotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), "Club not found");
    }
}
