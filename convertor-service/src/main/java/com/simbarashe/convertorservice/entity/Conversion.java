package com.simbarashe.convertorservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conversion")
public class Conversion {
    @Id
    @GeneratedValue
    private int id;
    private String fromUnit;
    private String toUnit;
    private double fromValue;
    private double toValue;
}
