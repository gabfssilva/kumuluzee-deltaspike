package com.thedevpiece.kumuluzee.deltaspike.api.utils;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class OperationRequest {
    private String op;
    private String path;
    private Object value;

    public Operation getOp() {
        return Operation.valueOf(op.toUpperCase());
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public enum Operation {
        ADD, REPLACE, REMOVE;
    }
}
