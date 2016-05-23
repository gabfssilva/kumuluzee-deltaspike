package com.thedevpiece.kumuluzee.deltaspike.api.exceptions;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class GenericHttpException extends RuntimeException {
    private int code;
    private String description;

    public GenericHttpException(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
