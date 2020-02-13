package com.moc.controllers.gestione_donatore;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.moc.models.Donatore;
import com.moc.models.Modulo;
import com.moc.models.Prenotazione;
import com.moc.security.UtenteCorrente;
import com.moc.services.DonatoreInterface;
import com.moc.services.ModuloInterface;
import com.moc.services.PrenotazioneInterface;
import com.moc.utils.InterfaceApi;
import com.moc.utils.ResponseCustomEntity;
import com.moc.utils.ResponseList;
import com.moc.utils.ResponseOK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * GestioneDonatore
 */
@RestController
public class GestioneDonatore implements GestioneDonatoreInterface {

    @Autowired
    private PrenotazioneInterface prenotazioneService;
    @Autowired
    private DonatoreInterface donatoreService;
    @Autowired
    private ModuloInterface moduloService;
    
    @Override
    public ResponseEntity<InterfaceApi> ottieniDate(UtenteCorrente utenteCorrente) {
        Donatore donatore = donatoreService.findByEmail(utenteCorrente.getEmail());
        List<Prenotazione> list = donatoreService.ottieniPrenotazioni(donatore);
        return new ResponseEntity<>(new ResponseList<Prenotazione>(list),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterfaceApi> prenotaData(UtenteCorrente utenteCorrente, Long idPrenotazione) {
        Donatore donatore = donatoreService.findByEmail(utenteCorrente.getEmail());
        Prenotazione prenotazione = prenotazioneService.findById(idPrenotazione);
        prenotazione = prenotazioneService.prenotaData(donatore, prenotazione);
        return new ResponseEntity<>(new ResponseOK("prenotazione effettuata"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterfaceApi> eliminareData(UtenteCorrente utenteCorrente, HttpServletRequest req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<InterfaceApi> modificareModulo(UtenteCorrente utenteCorrente, Modulo modulo) {
        Donatore donatore = donatoreService.findByEmail(utenteCorrente.getEmail());
        Modulo moduloSaved = moduloService.modificaModulo(modulo);
        donatoreService.modificaModulo(donatore,moduloSaved);
        return new ResponseEntity<>(new ResponseOK("modulo modificato con successo"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterfaceApi> modificareProfilo(UtenteCorrente utenteCorrente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<InterfaceApi> ottieniModulo(UtenteCorrente utenteCorrente) {
        Donatore donatore = donatoreService.findByEmail(utenteCorrente.getEmail());
        Modulo modulo = donatoreService.ottieniModulo(donatore);
        return new ResponseEntity<>(new ResponseCustomEntity<Modulo>(modulo),HttpStatus.OK);
    }

    
}