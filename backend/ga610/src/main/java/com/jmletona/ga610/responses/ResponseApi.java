package com.jmletona.ga610.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseApi<T> implements Serializable, IResponse {
    private   Boolean success;
    private   String message;
    private   transient T data;

    public ResponseApi(T data) {
        this.data = data;
    }

    public ResponseApi(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseApi(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseApi(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
