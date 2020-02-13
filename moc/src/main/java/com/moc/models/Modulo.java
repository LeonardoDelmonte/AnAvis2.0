package com.moc.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.Data;

/**
 * Modulo
 */
@Entity
@Data
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column@NotBlank@NotNull
    private String fumatore,sportivo,gruppoSanguigno;

}