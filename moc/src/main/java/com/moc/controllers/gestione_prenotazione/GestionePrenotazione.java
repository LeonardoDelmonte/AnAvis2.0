package com.moc.controllers.gestione_prenotazione;

import com.moc.dto.PrenotazionePerTerziDto;
import com.moc.models.Donatore;
import com.moc.models.Prenotazione;
import com.moc.security.UtenteCorrente;
import com.moc.services.DonatoreInterface;
import com.moc.services.PrenotazioneInterface;
import com.moc.utils.InterfaceApi;
import com.moc.utils.ResponseOK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * GestionePrenotazione
 */
@RestController
public class GestionePrenotazione implements GestionePrenotazioneInterface{

    @Autowired
    private DonatoreInterface donatoreService;
    @Autowired
    private PrenotazioneInterface prenotazioneService;

    @Override
    public ResponseEntity<InterfaceApi> prenotaPerTerzi(UtenteCorrente utenteCorrente,PrenotazionePerTerziDto dto) {
        prenota(dto.getEmail(), dto.getIdPrenotazione());
        return new ResponseEntity<>(new ResponseOK("prenotazione effettuata"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterfaceApi> prenotaData(UtenteCorrente utenteCorrente,Long idPrenotazione) {
        prenota(utenteCorrente.getEmail(), idPrenotazione);
        return new ResponseEntity<>(new ResponseOK("prenotazione effettuata"),HttpStatus.OK);
    }
    
    private Prenotazione prenota(String email,Long idPrenotazione){
        Donatore donatore = donatoreService.findByEmail(email);
        donatoreService.isModuloCompilato(donatore);
        donatoreService.isAbilitatoAdonare(donatore);
        Prenotazione prenotazione = prenotazioneService.findById(idPrenotazione);
        return prenotazioneService.prenotaData(donatore, prenotazione);
    }
    
    

}