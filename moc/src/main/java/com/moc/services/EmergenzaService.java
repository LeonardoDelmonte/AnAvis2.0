package com.moc.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.moc.models.CentroTrasfusione;
import com.moc.models.Emergenza;
import com.moc.repositories.EmergenzaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class EmergenzaService implements EmergenzaInterface {

    @Autowired
    private EmergenzaRepository emergenzaRepository;

    @Override
    public Emergenza findById(Long idEmergenza) {
        return emergenzaRepository.findById(idEmergenza).get();
    }

    @Override
    public void cancellaEmergenza(Emergenza emergenza) {
        emergenzaRepository.delete(emergenza);
    }

    @Override
    public void inserireEmergenza(String gruppo, CentroTrasfusione centro) {
        emergenzaRepository.save(Emergenza.builder().gruppoSanguigno(gruppo).idCentroTrasfusione(centro)
                .dataEmergenza(new Timestamp(new Date().getTime())).build());
    }

    @Override
    public List<?> contaEmergenze() {
        return emergenzaRepository.countGruppo();
    }

}