package com.simbarashe.convertorservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {
    @NotNull(message = "{amount.not-null}")
    private Double amount;
}
