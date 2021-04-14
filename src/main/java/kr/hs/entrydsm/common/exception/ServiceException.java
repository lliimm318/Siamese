package kr.hs.entrydsm.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public ServiceException(int statusCode, String message) {
        this.httpStatus = HttpStatus.valueOf(statusCode);
        this.message = message;
    }
}
