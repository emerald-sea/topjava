package ru.javawebinar.topjava.util.exception;

public class ErrorInfo {
    private final String url;
    private final ErrorType type;
    private final String detail;
    private final String typeMessage;

    public ErrorInfo(CharSequence url, ErrorType type, String detail) {
        this.url = url.toString();
        this.type = type;
        this.typeMessage = type.getMsg();
        this.detail = detail;
    }
}