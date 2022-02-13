package com.simbarashe.convertorservice.service;

import com.simbarashe.convertorservice.entity.Conversion;

import java.util.List;

public interface ConversionService {

    Double kelvinToCelsius(Double kelvin);
    Double celsiusToKelvin(Double celsius);
    Double milesToKilometres(Double miles);
    Double kilometresToMiles(Double Kilometres);
    List<Conversion> retrieveConversions();
}
