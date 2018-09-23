package com.casenet.exceptions;

public enum ErrorType {

    FILE_EXCEPTION(1, "Error openning the xml file"),
    XML_MAPPING_CLASS(2, "Error initializating xml mapping class"),
    PARSING_EXCEPTION(3, "Error parsing the xml file");

    private Integer erroCode;
    private String message;

    ErrorType(Integer erroCode, String message) {
        this.erroCode = erroCode;
        this.message = message;
    }

    public Integer getErroCode() {
        return erroCode;
    }

    public void setErroCode(Integer erroCode) {
        this.erroCode = erroCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
