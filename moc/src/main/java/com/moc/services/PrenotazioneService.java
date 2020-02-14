package com.moc.services;

import java.security.InvalidParameterException;
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
        //exception
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

    @Override
    public void eliminaData(Prenotazione prenotazione) {
        if(prenotazione.getIdDonatore()!=null){
           //manda una mail al donatore per comunicare la cancellazione della data
        }
        prenotazioneRepository.delete(prenotazione);       
    }

    @Override
    public void cancellaPrenotazione(Prenotazione prenotazione) {
        if(prenotazione.getIdDonatore()==null)
            throw new NoSuchElementException("la data è già libera");
        checkDate(prenotazione);
        prenotazione.setIdDonatore(null);
        prenotazioneRepository.save(prenotazione);
    }

    private void checkDate(Prenotazione prenotazione){
        //se la data è di oggi o del passato non la faccio eliminare, cambiare condizione if con now()>getDate()
        if(prenotazione.getDate()==null){
            throw new InvalidParameterException("la donazione è già stata effettuata, non si può eliminare");
        }
    }

    
}