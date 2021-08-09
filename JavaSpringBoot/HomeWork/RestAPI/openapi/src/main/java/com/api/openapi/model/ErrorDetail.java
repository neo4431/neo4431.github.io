package com.api.openapi.model;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetail {
    private java.util.Date errorTime;
    private String message;
    private String detail;

    public ErrorDetail(String message, String detail){
        this.message = message;
        this.detail = detail;
        this.errorTime = new Date();
    }
}
