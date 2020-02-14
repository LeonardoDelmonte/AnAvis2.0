package com.moc.services;

import java.util.List;

import com.moc.models.CentroTrasfusione;
import com.moc.models.Emergenza;
import com.moc.repositories.CentroTrasfusioneRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CentroTrasfusioneService implements CentroTrasfusioneInterface {

    @Autowired
    CentroTrasfusioneRepository centroRepository;

    @Override
    public CentroTrasfusione findByEmail(String email) {
        return centroRepository.findByEmail(email);
    }

    @Override
    public List<Emergenza> ottieniEmergenze(CentroTrasfusione centro) {
        return centro.getListaEmergenze();
    }

}