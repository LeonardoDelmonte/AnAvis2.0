package com.moc.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.moc.models.Utente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




/**
 * Utente->CentroTrasfusione
 */

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("CENTRO_TRASFUSIONE")

public class CentroTrasfusione extends Utente{

    //@OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="shop_owned_id",nullable=true)
    
    @Column
    private String direttore;
    @Column
    private String regione;
    @Column
    private String provincia;
    @Column
    private String comune;

    @OneToMany(mappedBy="idCentroTrasfusione",fetch = FetchType.LAZY)
    private List<Emergenza> listaEmergenze;

        
}