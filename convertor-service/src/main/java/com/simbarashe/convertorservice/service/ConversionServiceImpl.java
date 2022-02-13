package com.simbarashe.convertorservice.service;

import com.simbarashe.convertorservice.constants.UnitConstant;
import com.simbarashe.convertorservice.entity.Conversion;
import com.simbarashe.convertorservice.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    private ConversionRepository repository;

    @Override
    public Double kelvinToCelsius(Double kelvin) {
        Double celsius = kelvin - 273.15;
        Conversion conversion = new Conversion();
        conversion.setFromUnit(UnitConstant.KELVIN);
        conversion.setToUnit(UnitConstant.CELSIUS);
        conversion.setFromValue(kelvin);
        conversion.setToValue(celsius);
        repository.save(conversion);
        return celsius;
    }

    @Override
    public Double celsiusToKelvin(Double celsius) {
        Double kelvin = celsius + 273.15;
        Conversion conversion = new Conversion();
        conversion.setFromUnit(UnitConstant.CELSIUS);
        conversion.setToUnit(UnitConstant.KELVIN);
        conversion.setFromValue(celsius);
        conversion.setToValue(kelvin);
        repository.save(conversion);
        return kelvin;
    }

    @Override
    public Double milesToKilometres(Double miles) {
        Double Kilometres = miles * 1.60934;
        Conversion conversion = new Conversion();
        conversion.setFromUnit(UnitConstant.MILES);
        conversion.setToUnit(UnitConstant.KILOMETRES);
        conversion.setFromValue(miles);
        conversion.setToValue(Kilometres);
        repository.save(conversion);
        return Kilometres;
    }

    @Override
    public Double kilometresToMiles(Double Kilometres) {
        Double miles = Kilometres / 1.60934;
        Conversion conversion = new Conversion();
        conversion.setFromUnit(UnitConstant.KILOMETRES);
        conversion.setToUnit(UnitConstant.MILES);
        conversion.setFromValue(Kilometres);
        conversion.setToValue(miles);
        repository.save(conversion);
        return miles;
    }

    @Override
    public List<Conversion> retrieveConversions() {
        return  repository.findAll();
    }

}
