package com.thedevpiece.kumuluzee.deltaspike.entities.base;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class Message {
    private String message;
    private String type;

    public Message(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
