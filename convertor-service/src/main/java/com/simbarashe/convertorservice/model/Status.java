package com.simbarashe.convertorservice.model;


import com.simbarashe.convertorservice.constants.StatusConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    public Integer code;

    public String message;

    public Status(StatusConstants.HttpConstants httpConstants) {
        this.code = httpConstants.getCode();
        this.message = httpConstants.getDesc();
    }
}
