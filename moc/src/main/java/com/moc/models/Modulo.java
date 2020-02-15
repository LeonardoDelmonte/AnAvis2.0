package com.moc.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modulo
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Modulo {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String codiceFiscale, indirizzo, telefono, gruppoSanguigno, 
                fumatore, malattie, vaccinazioni, allergie,farmaci;
            
}