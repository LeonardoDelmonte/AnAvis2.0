package com.moc.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

import com.moc.models.Donatore;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;
import com.moc.repositories.PrenotazioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * PrenotazioneService
 */
@Service
public class PrenotazioneService implements PrenotazioneInterface {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Override
    public List<Timestamp> salvaListaDate(List<Timestamp> list, SedeAvis sedeAvis) {
        if (list.isEmpty() || sedeAvis == null)
            throw new NullPointerException("argomento passato NULL");

        return inserisciDataLibera(sedeAvis, list);
    }

    // ritorna la lista con le date inserite
    private List<Timestamp> inserisciDataLibera(SedeAvis sedeAvis, List<Timestamp> listTimestamp) {
        for (int i = 0; i < listTimestamp.size(); i++) {
            try {
                prenotazioneRepository
                        .save(Prenotazione.builder().date(listTimestamp.get(i)).idSedeAvis(sedeAvis).build());
            } catch (DataIntegrityViolationException e) {
                listTimestamp.remove(i);
            }
        }
        return listTimestamp;
    }

    @Override
    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).get();
    }

    @Override
    public Prenotazione prenotaData(Donatore donatore, Prenotazione prenotazione) {
        if(donatore == null || prenotazione == null){
            throw new NullPointerException("argomenti non validi"); 
        }
        if(donatore.getModulo()==null){
            throw new NoSuchElementException("modulo non compilato");
        }
        //check se null oppure rendi metodo syhncronized
        prenotazione.setIdDonatore(donatore);
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    
}