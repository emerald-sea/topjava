package ru.javawebinar.topjava.util.exception;

public enum ErrorType {
    APP_ERROR("Internal Server Error"),
    DATA_NOT_FOUND("Unprocessable Entity"),
    DATA_ERROR("Conflict"),
    VALIDATION_ERROR("Unprocessable Entity");

    private final String msg;

    ErrorType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
