package com.moc.controllers.gestione_donatore;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.moc.models.Donatore;
import com.moc.models.Prenotazione;
import com.moc.security.UtenteCorrente;
import com.moc.services.DonatoreInterface;
import com.moc.utils.InterfaceApi;
import com.moc.utils.ResponseList;
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
    private DonatoreInterface donatoreService;
    
    @Override
    public ResponseEntity<InterfaceApi> ottieniDate(UtenteCorrente utenteCorrente) {
        Donatore donatore = donatoreService.findByEmail(utenteCorrente.getEmail());
        List<Prenotazione> list = donatoreService.ottieniPrenotazioni(donatore);
        return new ResponseEntity<>(new ResponseList<Prenotazione>(list),HttpStatus.OK);
    }


    @Override
    public ResponseEntity<InterfaceApi> eliminareData(UtenteCorrente utenteCorrente, HttpServletRequest req) {
        // TODO Auto-generated method stub
        return null;
    }


    
}