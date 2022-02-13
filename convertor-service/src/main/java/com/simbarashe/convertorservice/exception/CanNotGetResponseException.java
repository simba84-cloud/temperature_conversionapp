package com.simbarashe.convertorservice.exception;


import com.simbarashe.convertorservice.constants.StatusConstants;
import lombok.Getter;

@Getter
public class CanNotGetResponseException extends RuntimeException {

    private StatusConstants.HttpConstants status;

    public CanNotGetResponseException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}
