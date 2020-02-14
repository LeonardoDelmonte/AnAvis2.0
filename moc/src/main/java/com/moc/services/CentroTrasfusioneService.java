package com.moc.services;

import java.util.List;

import com.moc.models.CentroTrasfusione;
import com.moc.models.Emergenza;
import com.moc.repositories.CentroTrasfusioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroTrasfusioneService implements CentroTrasfusioneInterface {

    @Autowired
    CentroTrasfusioneRepository centroRepository;

    @Override
    public CentroTrasfusione findByEmail(String email) {
        if(email==null)
            throw new NullPointerException("email NULL");
        return centroRepository.findByEmail(email);
    }

    @Override
    public List<Emergenza> ottieniEmergenze(CentroTrasfusione centro) {
        if(centro==null)
            throw new NullPointerException("centro NULL");
        return centro.getListaEmergenze();
    }

}