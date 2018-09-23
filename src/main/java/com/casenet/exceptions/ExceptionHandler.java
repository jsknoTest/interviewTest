package com.casenet.exceptions;

public class ExceptionHandler {

    public static void handleException(Throwable e, ErrorType error) {
        System.err.println("ErrorCode: " + error.getErroCode() + ", Message: " + error.getMessage());
        e.printStackTrace();
        throw new CasenetException(e, error);
    }
}
