package com.moc.services;
import java.util.List;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;
import com.moc.repositories.SedeAvisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SedeAvisService
 */
@Service
public class SedeAvisService implements SedeAvisInterface {

    @Autowired
    private SedeAvisRepository SedeAvisRepository;

    @Override
    public List<Prenotazione> ottieni(SedeAvis sedeAvis) {
       return sedeAvis.getListaPrenotazioni();
    }

    @Override
    public SedeAvis findByEmail(String email) {
        return SedeAvisRepository.findByEmail(email);
    }

    @Override
    public SedeAvis findByComune(String comune) {
        return SedeAvisRepository.findByComune(comune);
    }

    @Override
    public void elimina(Prenotazione prenotazione) {
        // TODO Auto-generated method stub
    }

    @Override
    public void modifica(Prenotazione prenotazione) {
        // TODO Auto-generated method stub
    }
    
}