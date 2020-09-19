package com.example.demo.Service;

/**
 * Created by lubov on 30.08.20.
 */
public class BaseResponse {

    private final String status;
    private final Integer code;

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public BaseResponse(String status, Integer code) {

        this.status = status;
        this.code = code;
    }
}
