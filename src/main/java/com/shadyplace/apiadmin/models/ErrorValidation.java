package com.shadyplace.apiadmin.models;

import java.util.Date;

public class ErrorValidation {

    private String input;
    private String message;
    private Long timestamp;

    public ErrorValidation(String input, String message) {
        this.input = input;
        this.message = message;
        this.timestamp = new Date().getTime();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
