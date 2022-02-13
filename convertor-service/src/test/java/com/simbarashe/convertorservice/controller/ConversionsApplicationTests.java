package com.simbarashe.convertorservice.controller;

import com.simbarashe.convertorservice.model.ConversionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ConversionsApplicationTests {

    @Autowired
    private ConverterController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void testConvertKevinToCelsiusSuccess()  {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(273.15D);

        ResponseEntity response = controller.convertKelvinToCelsius(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(0.0).isEqualTo(response.getBody());
    }

    @Test
    void testConvertKevinToCelsiusBadInput(){
        ResponseEntity response = controller.convertKelvinToCelsius(null);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }


    @Test
    void testConvertCelsiusToKelvinSuccess(){
        ConversionRequest request = new ConversionRequest();
        request.setAmount(1D);

        ResponseEntity response = controller.convertCelsiusToKelvin(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(274.15).isEqualTo(response.getBody());
    }

    @Test
    void testConvertCelsiusToKelvinBadInput() {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(null);

        ResponseEntity response = controller.convertCelsiusToKelvin(request);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }

    @Test
    void testConvertMilesToKilometersSuccess(){
        ConversionRequest request = new ConversionRequest();
        request.setAmount(1D);

        ResponseEntity response = controller.convertMilesToKilometers(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(1.60934).isEqualTo(response.getBody());
    }

    @Test
    void testConvertMilesToKilometersBadInput(){
        ConversionRequest request = new ConversionRequest();
        request.setAmount(null);

        ResponseEntity response = controller.convertMilesToKilometers(request);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }

    @Test
    void testConvertKilometersToMileSuccess() {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(1D);

        ResponseEntity response = controller.convertKilometersToMiles(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(0.6213727366498067).isEqualTo(response.getBody());
    }

    @Test
    void testConvertKilometersToMileBadInput() {
        ResponseEntity response = controller.convertKilometersToMiles(null);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }
}
