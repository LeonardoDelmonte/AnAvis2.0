package com.moc.controllers.gestione_donatore;

import javax.servlet.http.HttpServletRequest;

import com.moc.models.Modulo;
import com.moc.security.UtenteCorrente;
import com.moc.utils.InterfaceApi;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * GestioneDonatoreInterface
 */
public interface GestioneDonatoreInterface {

    @GetMapping(value="/donatore/gestione-date/ottieni-date")
    public ResponseEntity<InterfaceApi> ottieniDate(@AuthenticationPrincipal UtenteCorrente utenteCorrente);

    @GetMapping(value="/donatore/gestione-modulo/ottieni-modulo")
    public ResponseEntity<InterfaceApi> ottieniModulo(@AuthenticationPrincipal UtenteCorrente utenteCorrente);
    
    @PostMapping(value="/donatore/gestione-date/prenota-data")
    public ResponseEntity<InterfaceApi> prenotaData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody Long idPrenotazione);

    @DeleteMapping(value="/donatore/gestione-date/eliminare-data")
    public ResponseEntity<InterfaceApi> eliminareData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,HttpServletRequest req);
 
    @PutMapping(value="/donatore/gestione-modulo/modificare-modulo")
    public ResponseEntity<InterfaceApi> modificareModulo(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody Modulo modulo);
    
    @PutMapping(value="/donatore/gestione-profilo/modificare-profilo")
    public ResponseEntity<InterfaceApi> modificareProfilo(@AuthenticationPrincipal UtenteCorrente utenteCorrente);

       
}