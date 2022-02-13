package com.simbarashe.convertorservice.controller;

import com.simbarashe.convertorservice.constants.ConverterConstants;
import com.simbarashe.convertorservice.logging.TrackExecutionTime;
import com.simbarashe.convertorservice.model.ConversionRequest;
import com.simbarashe.convertorservice.service.ConversionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class ConverterController {

    @Autowired
    private ConversionServiceImpl conversionService;
    /**
     *  Converts given amount from Kelvin to Celsius.
     * @param conversionRequest
     * @return
     */
    @PostMapping(path = "/conversions/ktoc")
    @TrackExecutionTime
    public ResponseEntity convertKelvinToCelsius(@RequestBody @Nullable ConversionRequest conversionRequest) {
        if (conversionRequest == null || conversionRequest.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(conversionService.kelvinToCelsius(conversionRequest.getAmount()), HttpStatus.OK);
    }

    /**
     *  Converts given amount from Celsius to Kelvin.
     * @param conversionRequest
     * @return
     */
    @PostMapping(path = "/conversions/ctok")
    @TrackExecutionTime
    public ResponseEntity convertCelsiusToKelvin(@RequestBody @Nullable ConversionRequest conversionRequest) {
        if (conversionRequest == null || conversionRequest.getAmount() == null) {

            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(conversionService.celsiusToKelvin(conversionRequest.getAmount()), HttpStatus.OK);
    }

    /**
     *  Converts given amount from Miles to Kilometers.
     * @param conversionRequest
     * @return
     */
    @PostMapping(path = "/conversions/mtok")
    @TrackExecutionTime
    public ResponseEntity convertMilesToKilometers(@RequestBody @Nullable ConversionRequest conversionRequest) {
        if (conversionRequest == null || conversionRequest.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(conversionService.milesToKilometres(conversionRequest.getAmount()), HttpStatus.OK);
    }

    /**
     *  Converts given amount from Kilometers to Miles.
     * @param conversionRequest
     * @return
     */
    @PostMapping(path = "/conversions/ktom")
    @TrackExecutionTime
    public ResponseEntity convertKilometersToMiles(@RequestBody ConversionRequest conversionRequest) {
        if (conversionRequest == null || conversionRequest.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(conversionService.kilometresToMiles(conversionRequest.getAmount()), HttpStatus.OK);
    }
    @GetMapping(path = "/conversions/all")
    @TrackExecutionTime
    public ResponseEntity getAll() {

        return new ResponseEntity(conversionService.retrieveConversions(), HttpStatus.OK);
    }
}