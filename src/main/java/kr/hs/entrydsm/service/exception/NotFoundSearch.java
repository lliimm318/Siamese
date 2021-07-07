package kr.hs.entrydsm.service.exception;

import kr.hs.entrydsm.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class NotFoundSearch extends ServiceException {

    public NotFoundSearch() {
        super(HttpStatus.NOT_FOUND.value(), "No search result");
    }
}
