package com.moc.controllers.gestione_sede_avis;

import javax.servlet.http.HttpServletRequest;

import com.moc.dto.ModuloPerTerzi;
import com.moc.dto.PrenotazionePerTerziDto;
import com.moc.dto.RangeDateDto;
import com.moc.models.Prenotazione;
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
 * GestioneDateInterface
 */
public interface GestioneSedeAvisInterface {

    @GetMapping(value="/sedeAvis/gestione-date/ottieni-date")
    public ResponseEntity<InterfaceApi> ottieniDate(@AuthenticationPrincipal UtenteCorrente utenteCorrente);

    @GetMapping(value="/sedeAvis/ottieni-modulo-donatore")
    public ResponseEntity<InterfaceApi> ottieniModuloDonatore(@AuthenticationPrincipal UtenteCorrente utenteCorrente , @RequestBody String email);

    @PostMapping(value="/sedeAvis/gestione-date/inserimento-data")
    public ResponseEntity<InterfaceApi> inserireDateLibere(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody RangeDateDto inserimentoDto);

    @PostMapping(value="/sedeAvis/prenota-per-terzi")
    public ResponseEntity<InterfaceApi> prenotaPerTerzi(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody PrenotazionePerTerziDto prenotazionePerTerziDto);

    @PostMapping(value="/sedeAvis/modifica-modulo-per-terzi")
    public ResponseEntity<InterfaceApi> modificaModuloPerTerzi(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody ModuloPerTerzi moduloPerTerziDto);

    @PutMapping(value="/sedeAvis/gestione-date/modificare-data")
    public ResponseEntity<InterfaceApi> modificareData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody Prenotazione prenotazione);

    @DeleteMapping(value="/sedeAvis/gestione-date/eliminare-data")
    public ResponseEntity<InterfaceApi> eliminareData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,HttpServletRequest req);
    
}