package com.moc.services;

import java.util.List;

import com.moc.dto.SedeAvisProfiloDto;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;
import com.moc.repositories.SedeAvisRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SedeAvisService
 */
@Service
public class SedeAvisService implements SedeAvisInterface {

    @Autowired
    private SedeAvisRepository sedeAvisRepository;

    @Override
    public List<Prenotazione> ottieni(SedeAvis sedeAvis) {
        if(sedeAvis==null)
            throw new NullPointerException("sedeAvis NULL");
        return sedeAvis.getListaPrenotazioni();
    }

    @Override
    public SedeAvis findByEmail(String email) {
        if(email==null)
            throw new NullPointerException("email NULL");
        return sedeAvisRepository.findByEmail(email);
    }

    @Override
    public SedeAvis findByComune(String comune) {
        return sedeAvisRepository.findByComune(comune);
    }

    @Override
    public void elimina(Prenotazione prenotazione) {
        // TODO Auto-generated method stub
    }

    @Override
    public void modifica(Prenotazione prenotazione) {
        // TODO Auto-generated method stub
    }

    @Override
    public void modificaProfilo(SedeAvis sedeAvis, SedeAvisProfiloDto profilo) {
        ModelMapper mapper = new ModelMapper();
        mapper.map(profilo, sedeAvis);
        sedeAvisRepository.save(sedeAvis);
    }

    @Override
    public SedeAvisProfiloDto ottieniProfilo(SedeAvis sedeAvis) {
        ModelMapper mapper = new ModelMapper();
        SedeAvisProfiloDto profilo = mapper.map(sedeAvis,SedeAvisProfiloDto.class);
        return profilo;
    }
    
}