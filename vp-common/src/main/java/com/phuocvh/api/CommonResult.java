package com.phuocvh.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Long code;
    private String message;
    private T data;

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failed(IResultCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(IResultCode errorCode, String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }
}
