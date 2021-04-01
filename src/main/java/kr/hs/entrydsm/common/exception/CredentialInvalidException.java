package kr.hs.entrydsm.common.exception;

import org.springframework.http.HttpStatus;

public class CredentialInvalidException extends ServiceException {
    public CredentialInvalidException() { super(HttpStatus.UNAUTHORIZED.value(), "Credential is invalid"); }
}
