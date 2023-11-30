package com.phuocvh.api;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResultCode implements IResultCode {
    SUCCESS(200L, "SUCCESS"),
    FAILED(500L, "FAILED"),
    VALIDATE_FAILED(404L, "VALIDATE_FAILED"),
    UNAUTHORIZED(401L, "UNAUTHORIZED"),
    FORBIDDEN(403L, "FORBIDDEN"),
    ;

    private final Long code;
    private final String message;

    @Override
    public Long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
