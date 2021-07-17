package com.jmletona.ga610.responses;

import com.jmletona.ga610.model.Service;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponsePersonList<T> implements Serializable, IResponse{
    private   Boolean success;
    private Service service;
    private   transient T data;

    public ResponsePersonList(T data) {
        this.data = data;
    }

    public ResponsePersonList(Boolean success, String message) {
        this.success = success;
        //this.message = message;
    }

    public ResponsePersonList(Boolean success, String message, T data) {
        this.success = success;
        //this.message = message;
        this.data = data;
    }

    public ResponsePersonList(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
