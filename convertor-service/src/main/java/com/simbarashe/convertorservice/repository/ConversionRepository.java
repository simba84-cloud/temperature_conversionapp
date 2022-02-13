package com.simbarashe.convertorservice.repository;

import com.simbarashe.convertorservice.entity.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository  extends JpaRepository<Conversion,Integer> {

}
