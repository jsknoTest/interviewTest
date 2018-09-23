package com.casenet.exceptions;

public class CasenetException extends RuntimeException {

    private ErrorType code;

    public CasenetException(Throwable cause, ErrorType code) {
        super(code.getMessage(), cause);
        this.code = code;
    }

    public ErrorType getCode() {
        return code;
    }

    public void setCode(ErrorType code) {
        this.code = code;
    }
}
