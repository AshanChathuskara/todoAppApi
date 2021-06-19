package com.abc.todoAppApi.dto.responce;

import java.time.LocalDateTime;

public class CommonResponse {

    private String code;
    private String message;
    private LocalDateTime dateTime;
    private Object data;

    public CommonResponse() {
    }

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.data = "";
    }

    public CommonResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                ", data=" + data +
                '}';
    }
}
